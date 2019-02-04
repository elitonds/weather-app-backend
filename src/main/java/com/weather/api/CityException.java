package com.weather.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.weather.api.util.CityExceptionUtil;

/**
 * 
 * @author Eliton
 *
 * Custom Class Exception 
 */

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CityException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param e an instance of a Exception
	 */
	public CityException(Exception e) {
		super(CityExceptionUtil.getMessage(e));
	}
}
