package com.toolRentalAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toolRentalAPI.service.RentalService;

@RestController
@RequestMapping("/users/{userId}/tools/{toolId}/rentals")
public class RentedController {

	@Autowired
	private RentalService service; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllRentals() {
		return new ResponseEntity<Object>(service.getAllRentals(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{rentalId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getRental(@PathVariable Long rentalId) {
		return new ResponseEntity<Object>(service.getRental(rentalId), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{rentalId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> returnRental(@PathVariable Long rentalId) {
		try {
			return new ResponseEntity<Object>(service.returnRental(rentalId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createRental(@PathVariable Long toolId, @RequestBody String username) {
		try {
			return new ResponseEntity<Object>(service.createRental(toolId, username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
