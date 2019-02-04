package com.weather.api.util;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 
 * @author Eliton
 *
 * Treat all the System Exceptions
 */
public class CityExceptionUtil {

	/**
	 * Return an Exception treated
	 * 
	 * @param e
	 * @return an Exception treated
	 */
	public static String getMessage(Exception e) {
		if (e instanceof DuplicateKeyException)
			return "Não podem existir duas cidades com mesmo nome e país";
		if (e instanceof HttpClientErrorException 
				&& ((HttpClientErrorException) e).getRawStatusCode() == HttpStatus.NOT_FOUND.value())
			return "Cidade inexistente";
		else
			return e.getMessage();
	}
}
