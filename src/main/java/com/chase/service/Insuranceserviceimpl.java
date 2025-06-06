package com.chase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.InsuranceUtil.InsuranceNotFoundException;
import com.chase.controller.Insurancecontroller;
import com.chase.entity.Insurance;
import com.chase.repository.Insurancerepository;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class Insuranceserviceimpl implements Insuranceservice{
	
	public static void main(String[] args) {
		Insurancecontroller t = new Insurancecontroller();
		//t.displayuser();
	}

	@Autowired
	Insurancerepository insurancerepository;
	
	public Insuranceserviceimpl() {
		//To auto-generate constructor
	}

	@Override
	public Insurance addInsurance(Insurance insurance) {
		// TODO Auto-generated method stub
		
		try {
			
			List<String> arrayList = new ArrayList<>(insurance.getPhoneNumbers());
			List<String> linkedList = new LinkedList<>(insurance.getPhoneNumbers());
			
			long startArray = System.nanoTime();
			arrayList.add("Test-Array");
			arrayList.add("Test-Array");
			arrayList.add("Test-Array");
			long endArray = System.nanoTime();
			
			long startLinked = System.nanoTime();
			linkedList.add("Test-Linked");
			linkedList.add("Test-Linked");
			linkedList.add("Test-Linked");
			long endLinked = System.nanoTime();
			
			System.out.println("ArrayList operation time" +(endArray - startArray)+" ns");
			System.out.println("LinkedList operation time" +(endLinked - startLinked)+" ns");

		}
		finally {
			System.out.println("The finally block executes");

		}
		
		if(insurance.getEmail() == null || !insurance.getEmail().contains("@"))
		{
			System.out.println("Insurance having invalid emial format");
			throw new InsuranceNotFoundException("Insurance having invalid email format ot emial is null");
			
		}
		
		

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
		return insurancerepository.save(insurance);
	}

	@Override
	public Insurance getInsurance(Long insuranceId) {
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
		
		Map<String,List<Insurance>> hashMap = new HashMap<>();
		Map<String,List<Insurance>> linkedhashMap = new LinkedHashMap<>();
		Map<String,List<Insurance>> treeMap = new TreeMap<>();
		
		for(Insurance i:insurance) {
			String domain = i.getEmail().split("@")[1];
			hashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
			linkedhashMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
			treeMap.computeIfAbsent(domain, k -> new ArrayList<>()).add(i);
		}
		System.out.println("HashMap " + hashMap.keySet());
		System.out.println("LinkedHashMap " + linkedhashMap.keySet());
		System.out.println("TreeMap " + treeMap.keySet());

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
		
		Optional<Insurance> l= insurancerepository.findById(insurance.getInsuranceId());
		if(l.isEmpty()) {
			throw new InsuranceNotFoundException("Loan not found");
			
		}
		
		
		
		
		Set<String> rawSet = insurance.getInsuranceTypes();
		rawSet.removeIf(type -> type == null || type.trim().isEmpty());
		Set<String> hashSet = new HashSet<>(rawSet);
		System.out.println("hashSet:" + hashSet);
		
		Set<String> linkedhashSet = new LinkedHashSet<>(rawSet);
		System.out.println("linkedhashSet:" + linkedhashSet);
		
		Set<String> treeSet = new TreeSet<>(rawSet);
		System.out.println("TreeSet:" + treeSet);

		return null;
	}

	@Override
	public Insurance deleteInsurance(Long insuranceId) {
		// TODO Auto-generated method stub
		
		insurancerepository.deleteById(insuranceId);
		return null;
	}

}
