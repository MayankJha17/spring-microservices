package com.spring.hotelService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hotelService.model.Hotel;
import com.spring.hotelService.response.RestResponse;
import com.spring.hotelService.service.HotelService;

@RestController(value = "/hotel")
public class HotelRest {

	@Autowired
	HotelService service;

	@PostMapping(value = "/save")
	public ResponseEntity<RestResponse> saveHotel(@RequestBody Hotel hotel) {
		return service.addHotel(hotel);
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<RestResponse> deleteHotel(@RequestParam String id) {

		return service.deleteHotel(id);
	}

	@GetMapping(value = "/all")
	public ResponseEntity<RestResponse> allHotels() {

		return service.getAllHotels();
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<RestResponse> getHotelById(@RequestParam String id) {

		return service.getHotelById(id);
	}

}
