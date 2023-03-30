package com.spring.ratingService.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.ratingService.model.Rating;

@Component
public interface RatingService {

	Rating create(Rating rating);

	List<Rating> getAll();

	List<Rating> getAllByUserId(String id);

	List<Rating> getAllByHotelId(String id);

}
