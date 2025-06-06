package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.Test;
import com.chase.InsuranceUtil.FraudCheckTask;
import com.chase.entity.Insurance;
import com.chase.service.Insuranceservice;

@RestController
@RequestMapping

public class Insurancecontroller extends Test{
	
	public Insurancecontroller() {
	//To auto-generate constructor
	}
	
	@Autowired
	Insuranceservice insuranceservice;

	@PostMapping ("/addInsurance")
	public Insurance addInsurance(@RequestBody Insurance insurance) {
		
		Runnable fraudcheck = new FraudCheckTask(insurance.getEmail());
		new Thread(fraudcheck).start();
		return insuranceservice.addInsurance(insurance);
		
	}
	
	@GetMapping ("/getInsurances/{insuranceId}")
	public Insurance getInsurance(@PathVariable Long insuranceId) {
		return insuranceservice.getInsurance(insuranceId);
		
	}
	
	@GetMapping ("/getAllInsurances")
	public List<Insurance> getAllInsurance(){
		return insuranceservice.getAllInsurance();
		
	}
	
	@PutMapping ("/updateInsurance")
	public Insurance updateInsurance(@RequestBody Insurance insurance) {
		return insuranceservice.updateInsurance(insurance);
		
	}
	
	@DeleteMapping ("/deleteInsurance{insuranceId}")
	public Insurance deleteInsurance(@PathVariable Long insuranceId) {
		return insuranceservice.deleteInsurance(insuranceId);
		
	}
	
}
