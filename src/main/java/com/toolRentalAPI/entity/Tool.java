package com.toolRentalAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tool")
public class Tool {

	private long id; 
	private String toolName; 
	private String toolType; 
	private float rentalCost;
	private boolean needsRepaired;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getToolName() {
		return toolName;
	}
	
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	
	public String getToolType() {
		return toolType;
	}
	
	public void setToolType(String toolType) {
		this.toolType = toolType;
	}
	
	public float getRentalCost() {
		return rentalCost;
	}
	
	public void setRentalCost(float rentalCost) {
		this.rentalCost = rentalCost;
	}
	
	public boolean isNeedsRepaired() {
		return needsRepaired;
	}
	
	public void setNeedsRepaired(boolean needsRepaired) {
		this.needsRepaired = needsRepaired;
	} 
	
}
