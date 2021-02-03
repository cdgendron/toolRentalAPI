 package com.toolRentalAPI.entity;

import java.time.LocalDate;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rental")
public class Rental {

	private long id; 
	private LocalDate dateRented;
	private LocalDate dateReturned; 
	
	@JsonIgnore
	private User user; 
	@JsonIgnore
	private Tool tool;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getDateRented() {
		return dateRented;
	}
	
	public void setDateRented(LocalDate dateRented) {
		this.dateRented = dateRented;
	}
	
	public LocalDate getDateReturned() {
		return dateReturned;
	}
	
	public void setDateReturned(LocalDate dateReturned) {
		this.dateReturned = dateReturned;
	}
	
	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name = "toolId")
	public Tool getTool() {
		return tool;
	}
	
	public void setTool(Tool tool) {
		this.tool = tool;
	} 
	
}
