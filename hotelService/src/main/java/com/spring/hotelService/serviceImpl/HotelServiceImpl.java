package com.spring.hotelService.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.hotelService.helper.Helper;
import com.spring.hotelService.model.Hotel;
import com.spring.hotelService.repo.HotelRepository;
import com.spring.hotelService.response.RestResponse;
import com.spring.hotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepo;

	@Autowired
	Helper helper;

	@Override
	public ResponseEntity<RestResponse> addHotel(Hotel hotel) {

		if (helper.isValidHotel(hotel)) {
			return saveHotel(hotel);
		}

		RestResponse response = new RestResponse();
		response.setMessage("Hotel is invalid or value is missing");
		response.setStatus(false);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

	}

	@Override
	public ResponseEntity<RestResponse> deleteHotel(String id) {

		if (id == null || id.isEmpty()) {
			RestResponse response = new RestResponse();
			response.setMessage("Hotel is invalid or value is missing");
			response.setStatus(false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		return removeHotel(id);
	}

	@Override
	public ResponseEntity<RestResponse> getHotelById(String id) {
		if (id == null || id.isEmpty()) {
			RestResponse response = new RestResponse();
			response.setMessage("Hotel is invalid or value is missing");
			response.setStatus(false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}

		return getHotel(id);
	}

	@Override
	public ResponseEntity<RestResponse> getAllHotels() {
		RestResponse response = new RestResponse();
		List<Hotel> listOfHotel = hotelRepo.findAll();
		response.setStatus(true);
		response.setMessage("List of hotel");
		Map<String, Object> content = new HashMap<String, Object>();
		content.put("listOfHotel", listOfHotel);
		response.setContent(content);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	private ResponseEntity<RestResponse> saveHotel(Hotel hotel) {

		RestResponse response = new RestResponse();
		Hotel savedHotel = hotelRepo.save(hotel);
		response.setStatus(true);
		response.setMessage("Hotel is saved");
		Map<String, Object> content = new HashMap();
		content.put("id", savedHotel.getId());
		content.put("name", savedHotel.getName());
		content.put("location", savedHotel.getLocation());
		content.put("about", savedHotel.getAbout());
		response.setContent(content);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	private ResponseEntity<RestResponse> removeHotel(String id) {

		Optional<Hotel> optHotel = hotelRepo.findById(id);
		RestResponse response = new RestResponse();
		if (optHotel.isPresent()) {
			Hotel hotel = optHotel.get();
			hotelRepo.delete(hotel);
			response.setStatus(true);
			response.setMessage("Hotel is deleted");
			return ResponseEntity.status(HttpStatus.OK).body(response);

		} else {
			response.setMessage("Hotel not found");
			response.setStatus(false);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

	private ResponseEntity<RestResponse> getHotel(String id) {
		Optional<Hotel> optHotel = hotelRepo.findById(id);
		RestResponse response = new RestResponse();
		if (optHotel.isPresent()) {
			Hotel hotel = optHotel.get();
			response.setStatus(true);
			response.setMessage("Hotel found");
			Map<String, Object> content = new HashMap<String, Object>();
			content.put("id", hotel.getId());
			content.put("name", hotel.getName());
			content.put("location", hotel.getLocation());
			content.put("about", hotel.getAbout());
			response.setContent(content);
			return ResponseEntity.status(HttpStatus.OK).body(response);

		} else {
			response.setMessage("Hotel not found");
			response.setStatus(false);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
	}

}
