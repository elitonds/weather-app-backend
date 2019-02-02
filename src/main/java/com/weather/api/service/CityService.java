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

/**
 * 
 * @author Eliton
 *
 */

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

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

	public CityDto addOrUpdate(CityRequest request) {
		try {
			final String uri = "http://api.openweathermap.org/data/2.5/weather?q=" + request.getName() + ","
					+ request.getCountry() + "&appid=eb8b1a9405e659b2ffc78f0a520b1a46&units=metric&cnt=2";

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getForObject(uri, String.class);
			CityEntity entity = new CityEntity();
			entity.setId(request.getId());
			entity.setCountry(request.getCountry());
			entity.setName(request.getName());
			entity.setLat(request.getLat());
			entity.setLon(request.getLon());
			repository.save(entity);
			return new CityDto(entity.getId(), entity.getName(), entity.getCountry());
		} catch (RuntimeException e) {
			throw new CityException(e);
		}

	}

	public void delete(String id) {
		Optional<CityEntity> city = repository.findById(id);
		if (city.isPresent())
			repository.delete(city.get());
	}

}
