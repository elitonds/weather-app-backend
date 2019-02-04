package com.weather.api.controller;

import java.rmi.ServerException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.dto.CityDto;
import com.weather.api.dto.PageableDto;
import com.weather.api.request.CityRequest;
import com.weather.api.service.BaseController;
import com.weather.api.service.CityService;

/**
 * 
 * @author Eliton
 *
 */

@RestController
@RequestMapping(path = "/api/city")
public class CityController extends BaseController {

	@Autowired
	private CityService service;

	@GetMapping()
	@ResponseBody
	public PageableDto listAllPaged(@RequestParam("page") int page, @RequestParam("size") int size) {
		return service.listPaged(page, size);
	}

	@PostMapping(path = "/add")
	@ResponseBody
	public CityDto add(@RequestBody @Valid CityRequest request) throws ServerException {
		return service.addOrUpdate(request);
	}

	@PutMapping(path = "/update")
	@ResponseBody
	public CityDto update(@RequestBody @Valid CityRequest request) throws ServerException {
		return service.addOrUpdate(request);
	}

	@DeleteMapping(path = "/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}

}
