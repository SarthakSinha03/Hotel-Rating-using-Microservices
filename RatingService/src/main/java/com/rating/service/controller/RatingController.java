package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingService service;
	
	@GetMapping("/{id}")
	public Rating getById(@PathVariable("id") int id){
		return service.getById(id); 
	}
	
	@GetMapping
	public List<Rating> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/users/{userid}")
	public List<Rating> getByUserId(@PathVariable("userid") int userid){
		return service.getByUserId(userid);
	}
	
	
	@GetMapping("/hotels/{hotelid}")
	public List<Rating> getByHotelId(@PathVariable("hotelid") int hotelid){
		return service.getByHotelId(hotelid);
	}
	
	
	@PostMapping
	public Rating post(@RequestBody Rating r) {
		return service.saveRating(r);
	}
	
	
	// delete by rate id
	@DeleteMapping("/rating/{id}")
	public Rating delete(@PathVariable int id) {
		return service.deleteByRateId(id);
	}

	
	// Deleting all ratings by userId
	@DeleteMapping("/user/{id}")
	public List<Rating> deleteAll(@PathVariable int id) {
		List<Rating>list=service.deleteByUserId(id);
		return list;		
	}
	
}
