package com.spring.hotelService.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.hotelService.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

}
