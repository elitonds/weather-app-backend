package com.weather.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.api.CityException;
import com.weather.api.Repository.CityRepository;
import com.weather.api.document.CityEntity;
import com.weather.api.dto.CityDto;
import com.weather.api.dto.PageableDto;
import com.weather.api.request.CityRequest;
import com.weather.api.util.SystemContants;

/**
 * 
 * @author Eliton
 *
 *         Service responsible to manage the database
 */

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	/**
	 * Return all the cities registered in the Database TODO make the pagination
	 * 
	 * @param page the index of the page
	 * @param size max results
	 * @return all the cities
	 */
	public PageableDto listAll(int page, int size) {
		PageableDto result = new PageableDto();
		result.setData(new ArrayList<>());
		repository.findAll().forEach(entity -> {
			CityDto dto = new CityDto(entity.getId(), entity.getName(), entity.getCountry());
			result.getData().add(dto);
		});
		result.setTotal(10);
		return result;
	}

	/**
	 * Add or update a city
	 * 
	 * @param request
	 * @return a new city or a city updated
	 */
	public CityDto addOrUpdate(CityRequest request) {
		try {
			validCity(request.getName(), request.getCountry());
			CityEntity entity = new CityEntity();
			entity.setId(request.getId());
			entity.setCountry(request.getCountry());
			entity.setName(request.getName());
			entity.setLat(request.getLat());
			entity.setLon(request.getLon());
			repository.save(entity);
			return new CityDto(entity.getId(), entity.getName(), entity.getCountry());
		} catch (Exception e) {
			throw new CityException(e);
		}

	}

	/**
	 * Delete a City by id
	 * 
	 * @param id Id of a City
	 */
	public void delete(String id) {
		Optional<CityEntity> city = repository.findById(id);
		if (city.isPresent())
			repository.delete(city.get());
	}

	/**
	 * This method just verify if the city exists, cause it doesn't the method throw
	 * a new {@link CityException}
	 * 
	 * @param name    Name of a City
	 * @param country Country of a City
	 */
	private void validCity(String name, String country) {
		try {
			String uri = String.format("%sweather?q=%s,%s&appid=%s&units=metric&cnt=2", SystemContants.WEATHER_PATH,
					name, country, SystemContants.API_KEY);

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getForObject(uri, String.class);
		} catch (Exception e) {
			throw new CityException(e);
		}
	}

}
