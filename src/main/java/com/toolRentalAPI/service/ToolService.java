package com.toolRentalAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolRentalAPI.entity.Tool;
import com.toolRentalAPI.repository.ToolRepository;

@Service
public class ToolService {

	@Autowired
	private ToolRepository repo; 
	
	public Iterable<Tool> getTools() {
		return repo.findAll(); 
	}
	
	public Iterable<Tool> getToolsThatNeedRepaired() {
		return repo.findByRepairNeed(true);
	}
	
	public Tool createTool(Tool tool) {
		return repo.save(tool); 
	}
	
	
	public Tool updateTool(Tool tool, Long id) throws Exception{
		try {
			Tool oldTool = repo.findById(id).get(); 
			oldTool.setToolName(tool.getToolName());
			oldTool.setToolType(tool.getToolType());
			oldTool.setRentalCost(tool.getRentalCost());
			oldTool.setNeedsRepaired(tool.isNeedsRepaired());
			return repo.save(oldTool);
		} catch (Exception e) {
			throw new Exception ("Unable to update tool.");
		}
	}

	public void removeTool(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new Exception("Unable to delete product.");
		}
	}

}
