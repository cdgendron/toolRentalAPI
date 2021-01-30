package com.toolRentalAPI.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.toolRentalAPI.entity.Credentials;
import com.toolRentalAPI.entity.User;
import com.toolRentalAPI.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository repo; 
	
	public User register(Credentials cred) throws AuthenticationException{
		User user = new User(); 
		user.setUsername(cred.getUsername());
		user.setHash(BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt()));
		try {
			repo.save(user);
			return user;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username is not available.");
		}
	}
	
	public User login(Credentials cred) throws AuthenticationException {
		User foundUser = repo.findByUsername(cred.getUsername());
		if( foundUser !=null && BCrypt.checkpw(cred.getPassword(), foundUser.getHash())) {
			return foundUser;
		}
		throw new AuthenticationException("Invalid username or password");
	}
}
