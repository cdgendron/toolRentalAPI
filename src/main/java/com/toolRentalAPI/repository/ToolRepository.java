package com.toolRentalAPI.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.toolRentalAPI.entity.Tool;

public interface ToolRepository extends CrudRepository<Tool, Long>{

	List<Tool> findByRepairNeed(Boolean needsRepaired);
	
}
