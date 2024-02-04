package com.user.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.user.service.entities.Hotel;


@EnableGlobalMethodSecurity(prePostEnabled = true)
public interface HotelRepo extends JpaRepository<Hotel, Integer>{
	
	public Hotel findByHotelId(int id);

}
