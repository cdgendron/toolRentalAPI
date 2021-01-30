package com.toolRentalAPI.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toolRentalAPI.entity.Credentials;
import com.toolRentalAPI.service.AuthService;
import com.toolRentalAPI.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping(value="/register", method=RequestMethod.POST) 
	public ResponseEntity<Object> register(@RequestBody Credentials cred){
		try {
			return new ResponseEntity<Object>(authService.register(cred), HttpStatus.CREATED);
		}catch(AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> Login(@RequestBody Credentials cred) {
		try {
			return new ResponseEntity<Object>(authService.login(cred), HttpStatus.OK);
		}catch(AuthenticationException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getUser() {
		return new ResponseEntity<Object>(userService.getUser(), HttpStatus.OK);
	}
}
