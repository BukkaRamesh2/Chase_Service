package com.chase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.controller.Insurancecontroller;
import com.chase.entity.Insurance;
import com.chase.repository.Insurancerepository;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class Insuranceserviceimpl implements Insuranceservice{
	
	public static void main(String[] args) {
		Insurancecontroller t = new Insurancecontroller();
		t.displayuser();
	}

	@Autowired
	Insurancerepository insurancerepository;
	
	public Insuranceserviceimpl() {
		//To auto-generate constructor
	}

	@Override
	public Insurance addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		
		if (insurance.getInsuranceType() == null) {
			System.out.println("The customer doesnot have any Insurance");
		}
		else {
			switch(insurance.getInsuranceType().toLowerCase()) {
			case "health":
				System.out.println("Customer has an Health Insurance");
				break;
			case "travel":
				System.out.println("Customer has an Travel Insurance");
				break;
			case "automobile":
				System.out.println("Customer has an Automobile Insurance");
				break;
			case "property":
				System.out.println("Customer has an Property Insurance");
				break;
			default:
				System.out.println("Customer has other insurances");
			}
		}
		return null;
	}

	@Override
	public Insurance getInsurance(long insuranceId) {
		// TODO Auto-generated method stub
		
		if(insuranceId != null && insuranceId > 0) {
			System.out.println("Customer is having Insurance");
		}
		else {
			System.out.println("Customer doesn't have any Insurance");
			return insurancerepository.getById(insuranceId);
		}
		return null;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		// TODO Auto-generated method stub
		
		List<Insurance> insurance = insurancerepository.findAll();
		if (insurance.isEmpty()) {
			System.out.println("There are no Insurances found");
		}
		else {
			insurance.forEach(Insurance -> {
				if(Insurance.getStatus()) {
					System.out.println("The Insurances are in active status");
				}
			});
		}
		return null;
	}

	@Override
	public Insurance updateInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Insurance deleteInsurance(long insuranceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
