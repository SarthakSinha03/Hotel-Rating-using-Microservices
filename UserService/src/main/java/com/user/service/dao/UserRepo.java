package com.user.service.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.user.service.entities.User;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByUserId(int id);
	
	public User deleteByUserId(int id);

}
