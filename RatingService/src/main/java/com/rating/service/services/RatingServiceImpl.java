package com.rating.service.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rating.service.Exceptions.ResourceNotFoundException;
import com.rating.service.entities.Rating;
import com.rating.service.repository.RatingRepo;
import jakarta.transaction.Transactional;


@Component
@Transactional
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepo repo;
	
	
	@Override
	public Rating saveRating(Rating r) {
		return repo.save(r);		
	}

	@Override
	public Rating getById(int id) {
		try {
			return repo.findByRateId(id);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Rating not available with RatingId: "+id);
		}
	}

	@Override
	public List<Rating> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Rating> getByHotelId(int id) {
		return repo.findByHotelId(id);
	}

	@Override
	public List<Rating> getByUserId(int id) {
	//	System.out.println("lets gooooooo");
		return repo.findByUserId(id);
	}

	@Override
	public Rating deleteByRateId(int id) {
		return repo.deleteByRateId(id);
	}

	public List<Rating> deleteByUserId(int id) {
		List<Rating> list=repo.findByUserId(id);
		List<Rating> dellist=new ArrayList<Rating>();
		for(Rating r:list) {
			dellist.add(repo.deleteByRateId(r.getRateId()));
		}
		return dellist;
	}

}
