package com.chase.service;

import java.util.List;

import com.chase.entity.Branch;

public interface branchservice {
	
	public Branch addBranch(Branch branch);
	public Branch getBranch(int branchId);
	public List<Branch> getallBranchs();
	public Branch updateBranch(Branch branch);
	public Branch deleteBranch(int branchId);
	List<Branch> getAllBranches();
	Branch deleteBranch(Long branchId);
	Branch getbranch(Long branchId);


}