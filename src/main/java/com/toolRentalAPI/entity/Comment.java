package com.toolRentalAPI.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	private Long id; 
	private String comment;
	private Date date; 
	private boolean needsRepaired; 
	
	@JsonIgnore
	private Rented rental; 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isNeedsRepaired() {
		return needsRepaired;
	}

	public void setNeedsRepaired(boolean needsRepaired) {
		this.needsRepaired = needsRepaired;
	}

	@ManyToOne
	@JoinColumn(name = "rentalId")
	public Rented getRental() {
		return rental;
	}

	public void setRental(Rented rental) {
		this.rental = rental;
	}

}
