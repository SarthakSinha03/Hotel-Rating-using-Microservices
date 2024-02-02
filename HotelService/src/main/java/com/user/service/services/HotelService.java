package com.user.service.services;

import java.util.List;

import com.user.service.entities.Hotel;

public interface HotelService {
	
	public Hotel savehotel(Hotel h);
	
	public Hotel gethotel(int id);
	
	public List<Hotel> getAll();
}
