package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.entity.Insurance;
import com.chase.service.Insuranceservice;

@RestController
@RequestMapping

public class Insurancecontroller {
	
	public Insurancecontroller() {
		//To auto-generate constructor
	}
	
	@Autowired
	Insuranceservice insuranceservice;

	@PostMapping
	public Insurance addInsurance(Insurance insurance) {
		return insuranceservice.addInsurance(insurance);
		
	}
	
	@GetMapping
	public Insurance getInsurance(long insuranceId) {
		return insuranceservice.getInsurance(insuranceId);
		
	}
	
	@GetMapping
	public List<Insurance> getAllInsurance(){
		return insuranceservice.getAllInsurance();
		
	}
	
	@PutMapping
	public Insurance updateInsurance(Insurance insurance) {
		return insuranceservice.updateInsurance(insurance);
		
	}
	
	@DeleteMapping
	public Insurance deleteInsurance(long insuranceId) {
		return insuranceservice.deleteInsurance(insuranceId);
		
	}
	
}
