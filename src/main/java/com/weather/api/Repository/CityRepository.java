package com.weather.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.weather.api.document.CityEntity;

/**
 * City repository 
 * 
 * @author Eliton
 *
 */

public interface CityRepository extends MongoRepository<CityEntity, String> {
	
}
