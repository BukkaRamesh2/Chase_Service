package com.chase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chase.entity.Branch;
import com.chase.repository.branchrepository;

@Service
public class branchserviceimpl implements branchservice {

    @Autowired
    private branchrepository branchRepository;

    @Override
    public Branch addBranch(Branch branch) {
        if (branch.getName() == null || branch.getName().isEmpty()) {
            System.out.println("Branch name is missing.");
            return null;
        }

        return branchRepository.save(branch);
    }

    @Override
    public Branch getBranch(int branchId) {
        if (branchId > 0) {
            Optional<Branch> optionalBranch = branchRepository.findById((long) branchId);
            return optionalBranch.orElse(null);
        } else {
            System.out.println("Invalid branch ID provided.");
            return null;
        }
    }

    @Override
    public List<Branch> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        if (branches.isEmpty()) {
            System.out.println("No branches found.");
        }
        return branches;
    }

    @Override
    public Branch updateBranch(Branch branch) {
        if (branch.getBranchId() != null && branchRepository.existsById(branch.getBranchId())) {
            return branchRepository.save(branch);
        }
        System.out.println("Update failed: Branch ID is missing or invalid.");
        return null;
    }

    @Override
    public Branch deleteBranch(int branchId) {
        Optional<Branch> optionalBranch = branchRepository.findById((long) branchId);
        if (optionalBranch.isPresent()) {
            branchRepository.delete(optionalBranch.get());
            System.out.println("Branch deleted with ID: " + branchId);
            return optionalBranch.get();
        } else {
            System.out.println("Branch not found for deletion.");
            return null;
        }
    }

	@Override
	public List<Branch> getallBranchs() {
		// TODO Auto-generated method stub
		return null;
	}
}
