package com.chase.service;

import java.util.List;

import com.chase.entity.Insurance;

public interface Insuranceservice {
	
	public Insurance addInsurance(Insurance insurance);
	public Insurance getInsurance(long insuranceId);
	public List<Insurance> getAllInsurance();
	public Insurance updateInsurance(Insurance insurance);
	public Insurance deleteInsurance(long insuranceId);
	
	
	

}
