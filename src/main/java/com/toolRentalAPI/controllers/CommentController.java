package com.toolRentalAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toolRentalAPI.entity.Comment;
import com.toolRentalAPI.service.CommentService;

@RestController
@RequestMapping("/rentals/{rentalId}/users/{userId}/comments")
public class CommentController {

	private CommentService service; 
	
	public ResponseEntity<Object> createComment(@RequestBody Comment comment,
			@PathVariable Long rentalId) {
		try {
			return new ResponseEntity<Object>(service.createComment(comment, rentalId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST); 
		}
	}
	
	@RequestMapping(value = "/{commentId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteComment(@PathVariable Long commentId) {
		service.deleteComment(commentId);
		return new ResponseEntity<Object>("Deleted comment with id:" + commentId, HttpStatus.OK);
	}
	
}
