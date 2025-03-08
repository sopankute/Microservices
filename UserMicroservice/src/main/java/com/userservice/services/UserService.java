package com.userservice.services;

import java.util.List;

import com.userservice.entities.User;

public interface UserService {
	
//	create, update, delete, getUser, getAllUsers
	
	User saveUser(User user);
	
	// TODO: 
	User updateUser();	
	
	// TODO:
	boolean deleteUser(Integer userId);
	
	User getUser(Integer userId);
	
	List<User> getAllUsers();
}
