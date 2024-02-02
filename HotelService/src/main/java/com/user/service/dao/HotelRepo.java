package com.user.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{
	
	public Hotel findByHotelId(int id);

}
