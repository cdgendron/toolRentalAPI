package com.toolRentalAPI.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolRentalAPI.entity.Comment;
import com.toolRentalAPI.entity.Rented;
import com.toolRentalAPI.repository.CommentRepository;
import com.toolRentalAPI.repository.RentedRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repo; 
	
	@Autowired
	private RentedRepository rentalRepo;
	
	public Comment createComment(Comment comment, Long rentalId) throws Exception {
		Rented rental = rentalRepo.findById(rentalId).get();
		if(rental == null) {
			throw new Exception("Rental does not exist.");
		}
		comment.setDate(new Date());
		comment.setRental(rental);
		return repo.save(comment); 
	}
	
	public void deleteComment(Long commentId) {
		repo.deleteById(commentId); 
	}
	
}
