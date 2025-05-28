package com.chase.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Branch addBranch(Branch branch) {
		
		return custservice.addBranch(branch);
		}
	
	
	public Branch getBranch(int branchId) {
		
		return custservice.getBranch(branchId);
		}
	
	
	public List<Branch> getallBranchs(){
		
		return custservice.getallBranchs();
		}
	
	
	public Branch updateBranch(Branch branch) {
		
		return custservice.updateBranch(branch);
		}
	
	
	public Branch deleteBranch(int branchId) {
		return custservice.deleteBranch(branchId);
		
	}

	
	
	}

