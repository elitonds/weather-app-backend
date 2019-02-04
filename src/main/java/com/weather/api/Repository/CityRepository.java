package com.weather.api.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.weather.api.document.CityEntity;

/**
 * City repository 
 * 
 * @author Eliton
 *
 */

public interface CityRepository extends MongoRepository<CityEntity, String> {
	
	Page<CityEntity> findAll(Pageable pageable);
}
