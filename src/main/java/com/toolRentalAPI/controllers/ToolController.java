package com.toolRentalAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toolRentalAPI.entity.Tool;
import com.toolRentalAPI.service.ToolService;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	private ToolService service; 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getTools() {
		return new ResponseEntity<Object>(service.getTools(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/repair", method=RequestMethod.GET)
	public ResponseEntity<Object> getToolsThatNeedRepaired() {
		return new ResponseEntity<Object>(service.getToolsThatNeedRepaired(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createTool(@RequestBody Tool tool) {
		return new ResponseEntity<Object>(service.createTool(tool), HttpStatus.CREATED);
	}
	
}
