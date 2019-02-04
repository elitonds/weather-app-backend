package com.weather.api.dto;

import java.util.List;

/**
 * Pageable DTO 
 * 
 * @author Eliton
 *
 */

public class PageableDto {
	
	private List<BaseDto> data;
	private long total;

	public List<BaseDto> getData() {
		return data;
	}

	public void setData(List<BaseDto> data) {
		this.data = data;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
