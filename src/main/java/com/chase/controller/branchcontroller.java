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

import com.chase.entity.Branch;
import com.chase.service.branchservice;


@RestController
@RequestMapping

public class branchcontroller {
	
	public branchcontroller() {
		
	}
	
	@Autowired
	branchservice custservice;
	
	
	@PostMapping("/addBranch")
	public Branch addBranch(@RequestBody Branch branch) {
		
		return custservice.addBranch(branch);
		}
	
	
	@GetMapping("/getBranch/{branchId}")
	public Branch getBranch(@PathVariable int branchId) {
		
		return custservice.getBranch(branchId);
		}
	
	@GetMapping("/getallBranches")
	public List<Branch> getallBranchs(){
		
		return custservice.getallBranchs();
		}
	
	@PutMapping("/updateBranch")
	public Branch updateBranch(@RequestBody Branch branch) {
		
		return custservice.updateBranch(branch);
		}
	
	@DeleteMapping("/deleteBranch/{branchId}")
	public Branch deleteBranch(@PathVariable int branchId) {
		return custservice.deleteBranch(branchId);
		
	}

	
	
	}

