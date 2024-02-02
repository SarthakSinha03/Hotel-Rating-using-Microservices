package com.user.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.service.dao.HotelRepo;
import com.user.service.entities.Hotel;
import com.user.service.exceptions.ResourceNotFoundException;

@Component
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepo repo;

	@Override
	public Hotel savehotel(Hotel h) {
		return repo.save(h);
	}

	@Override
	public Hotel gethotel(int id) {
		try {
			return repo.findByHotelId(id);
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("Hotel does not exist with HotelId: "+id);
		}
	}

	@Override
	public List<Hotel> getAll() {
		return repo.findAll();
	}

}
