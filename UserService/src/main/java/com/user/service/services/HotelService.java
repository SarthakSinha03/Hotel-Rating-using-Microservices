package com.user.service.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Hotel;

@FeignClient("HOTEL-SERVICE")
public interface HotelService {
	
	
	@GetMapping("/hotels/id/{id}")
	Hotel getHotel(@PathVariable("id") int id);
	
	
	@GetMapping("/hotels")
	List<Hotel> getAll();
	
	
}
