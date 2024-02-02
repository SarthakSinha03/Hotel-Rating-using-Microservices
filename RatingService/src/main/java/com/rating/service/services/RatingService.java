package com.rating.service.services;

import java.util.List;
import com.rating.service.entities.Rating;

public interface RatingService {
	
	public Rating saveRating(Rating r);
	
	public Rating getById(int id);
	
	public List<Rating> getAll();
	
	public List<Rating> getByHotelId(int id);
	
	public List<Rating> getByUserId(int id);
	
	public Rating deleteByRateId(int id);
	
	public List<Rating> deleteByUserId(int id);
	
	
	
}
