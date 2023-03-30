package com.spring.ratingService.endpoint;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ratingService.model.Rating;
import com.spring.ratingService.service.RatingService;

@RestController(value = "/rating")
public class RatingController {

	@Autowired
	RatingService service;
    
	
	@PostMapping("/save")
	public ResponseEntity<Rating> save(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.OK).body(service.create(rating));
	}
    
	@GetMapping("/all")
	public ResponseEntity<List<Rating>> getAll(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
    
	@GetMapping("/all/by/user/id/{id}")
	public ResponseEntity<List<Rating>> getByUserId(@PathParam(value = "id") String id) {

		return ResponseEntity.status(HttpStatus.OK).body(service.getAllByUserId(id));
	}
	
	@GetMapping("/all/by/hotel/id/{id}")
	public ResponseEntity<List<Rating>> getByHotelId(@PathParam(value = "id") String id) {

		return ResponseEntity.status(HttpStatus.OK).body(service.getAllByHotelId(id));
	}

}
