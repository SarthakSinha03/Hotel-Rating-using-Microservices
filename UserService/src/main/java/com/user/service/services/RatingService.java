package com.user.service.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.service.entities.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {
	
	
	@PostMapping("/ratings")
	public void addRating(Rating r);
	
	
	@DeleteMapping("/ratings/user/{id}")
	public List<Rating> delete(@PathVariable int id);
	
	@DeleteMapping("/ratings/rating/{id}")
	public Rating deleteByRateId(@PathVariable int id);
}
