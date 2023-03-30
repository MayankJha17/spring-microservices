package com.spring.ratingService.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ratingService.Repo.RatingRepo;
import com.spring.ratingService.model.Rating;
import com.spring.ratingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllByUserId(String id) {
		return ratingRepo.findByUserId(id);
	}

	@Override
	public List<Rating> getAllByHotelId(String id) {
		return ratingRepo.findByHotelId(id);
	}

}
