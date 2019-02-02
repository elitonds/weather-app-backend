package com.weather.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.weather.api.document.CityEntity;

/**
 * 
 * @author Eliton
 *
 */

public interface CityRepository extends MongoRepository<CityEntity, String> {
	
}
