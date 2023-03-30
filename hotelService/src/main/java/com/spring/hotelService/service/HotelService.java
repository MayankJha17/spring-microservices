package com.spring.hotelService.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.spring.hotelService.model.Hotel;
import com.spring.hotelService.response.RestResponse;

@Component
public interface HotelService {

	public ResponseEntity<RestResponse> addHotel(Hotel hotel);

	public ResponseEntity<RestResponse> deleteHotel(String id);

	public ResponseEntity<RestResponse> getHotelById(String id);

	public ResponseEntity<RestResponse> getAllHotels();

}
