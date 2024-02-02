package com.user.service.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByUserId(int id);
	
	public User deleteByUserId(int id);

}
