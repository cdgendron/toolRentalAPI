package com.toolRentalAPI.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolRentalAPI.entity.Rental;
import com.toolRentalAPI.entity.Tool;
import com.toolRentalAPI.entity.User;
import com.toolRentalAPI.repository.RentalRepository;
import com.toolRentalAPI.repository.ToolRepository;
import com.toolRentalAPI.repository.UserRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository repo; 
	
	@Autowired
	private UserRepository userRepo; 
	
	@Autowired
	private ToolRepository toolRepo; 
	
	public Iterable<Rental> getAllRentals(){
		return repo.findAll(); 
	}
	
	public Rental getRental(Long id) {
		return repo.findById(id).get(); 
	}
	
	public Rental returnRental(Long rentalId) throws Exception {
		Rental rental = repo.findById(rentalId).get();
		if (rental == null) {
			throw new Exception("Rental not found.");
		}
		rental.setDateReturned(LocalDate.now());
		return repo.save(rental);
	}
	
	public Rental createRental(Long toolId, String username) throws Exception {
		User user = userRepo.findByUsername(username);
		Tool toolRequest = toolRepo.findById(toolId).get(); //this will need to change 
		//I need to create an array that has all rented tools. 
		
		if (user == null) {
			throw new Exception("User not found."); 

//		} else if (toolRequest == null) {
//			throw new Exception("Tool in use"); //will need to adjust to check the array of rented tools. 
		
		}
		Rental rental = new Rental(); 
		rental.setTool(toolRequest);
		rental.setUser(user);
		rental.setDateRented(LocalDate.now());
		return rental; 
	}
}
