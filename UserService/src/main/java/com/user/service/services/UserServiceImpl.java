package com.user.service.services;


import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.user.service.dao.UserRepo;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	RestTemplate resttemp;
	
	@Autowired
	HotelService hotelservice;
	
	@Autowired
	RatingService RateService;
	
	@Override
	public User getuser(int id) {
		User u=repo.findByUserId(id);
		if(u==null) {
			throw new ResourceNotFoundException("User does not exist for userId: "+id);
		}
		List<Rating> list=getRatingList(id);
		u.setRating(list);		
		return u;
	}
	
	public List<Rating> getRatingList(int id){
		Rating arr[]=resttemp.getForObject("http://RATING-SERVICE/ratings/users/"+id, Rating[].class);
		List<Rating> list=new ArrayList<Rating>();
		for(Rating r:arr) {
			list.add(r);
		}
		for(Rating r: list) {
			r.setHotel(hotelservice.getHotel(r.getHotelId()));
		}
		return list;
	}
	

	@Override
	public List<User> getall() {
		List<User> list=repo.findAll();
		for(User u: list) {
			u.setRating(getRatingList(u.getUserId()));
		}
		return list;
	}

	@Override
	public User saveUser(User u) {
		return repo.save(u);
	}
	

	public Rating addRating(Rating r) {
		RateService.addRating(r);
		return r;
	}
	
	public User delete(int id) {
		List<Rating> list=RateService.delete(id);
		User u1=repo.findByUserId(id);
		repo.delete(u1);
		u1.setRating(list);
		return u1;
	}
	
	public Rating deleteByRateId(int id) {
		return RateService.deleteByRateId(id);
	}
		

}
