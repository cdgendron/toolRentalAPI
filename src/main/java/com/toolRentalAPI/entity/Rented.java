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
public class Rented {

	private long id; 
	private Date dateRented;
	private Date dateReturned; 
	
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
	
	public Date getDateRented() {
		return dateRented;
	}
	
	public void setDateRented(Date dateRented) {
		this.dateRented = dateRented;
	}
	
	public Date getDateReturned() {
		return dateReturned;
	}
	
	public void setDateReturned(Date dateReturned) {
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
