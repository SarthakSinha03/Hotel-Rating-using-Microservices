package com.rating.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.rating.service.entities.Rating;


public interface RatingRepo extends MongoRepository<Rating, Integer>{
	
	public Rating findByRateId(int id);
	
	public List<Rating> findByUserId(int id);
	
	public List<Rating> findByHotelId(int id);
	
	public Rating deleteByRateId(int id);
	

}
