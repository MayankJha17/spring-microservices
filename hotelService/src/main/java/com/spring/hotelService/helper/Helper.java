package com.spring.hotelService.helper;

import org.springframework.stereotype.Component;

import com.spring.hotelService.model.Hotel;

@Component
public class Helper {

	public boolean isValidHotel(Hotel hotel) {
		return !hotel.getName().isEmpty() && !hotel.getLocation().isEmpty();
	}

}
