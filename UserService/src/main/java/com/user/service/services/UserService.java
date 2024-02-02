package com.user.service.services;

import java.util.List;

import com.user.service.entities.User;

public interface UserService {
	
	public User getuser(int id);
	
	public List<User> getall();
	
	public User saveUser(User u);
	
	public User delete(int id);

}
