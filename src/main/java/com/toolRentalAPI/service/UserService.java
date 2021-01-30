package com.toolRentalAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolRentalAPI.entity.User;
import com.toolRentalAPI.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo; 
	
	public Iterable<User> getUser() {
		return repo.findAll(); 
	}
	
}
