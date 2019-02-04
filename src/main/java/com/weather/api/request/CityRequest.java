package com.weather.api.request;

import javax.validation.constraints.NotNull;

/**
 * City Request
 * 
 * @author Eliton
 *
 */

public class CityRequest {

	private String id;
	@NotNull(message="O nome da cidade não pode ser nulo")
	private String name;
	@NotNull(message="O país não pode ser nulo")
	private String country;
	private float lon;
	private float lat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
}
