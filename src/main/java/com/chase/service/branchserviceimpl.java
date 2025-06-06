package com.chase.service;

import java.util.*;
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
        boolean isValid = true;

        if (branch.getName() == null || branch.getName().isEmpty()) {
            System.out.println("Branch name is missing.");
            isValid = false;
        }

        if (branch.getAddress() == null || branch.getAddress().isEmpty()) {
            System.out.println("Branch address is missing.");
            isValid = false;
        }

        if (branch.getTimings() <= 0) {
            System.out.println("Branch timings must be positive.");
            isValid = false;
        }

        if (!isValid) {
            System.out.println("Branch creation failed due to invalid input.");
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
            return branches;
        }

       
        Map<String, List<Branch>> managerMap = new HashMap<>();
        Map<String, List<Branch>> addressMap = new TreeMap<>();

        for (Branch b : branches) {
            if (b.getManager() != null) {
                managerMap.computeIfAbsent(b.getManager(), k -> new ArrayList<>()).add(b);
            }
            if (b.getAddress() != null) {
                addressMap.computeIfAbsent(b.getAddress(), k -> new ArrayList<>()).add(b);
            }
        }

        System.out.println("Managers in branches (HashMap): " + managerMap.keySet());
        System.out.println("Sorted addresses (TreeMap): " + addressMap.keySet());

    
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        for (Branch b : branches) {
            if (b.getManager() != null) {
                hashSet.add(b.getManager());
                linkedHashSet.add(b.getManager());
                treeSet.add(b.getManager());
            }
        }

        System.out.println("HashSet (Unordered Managers): " + hashSet);
        System.out.println("LinkedHashSet (Insertion Order): " + linkedHashSet);
        System.out.println("TreeSet (Sorted): " + treeSet);

        return branches;
    }

    @Override
    public Branch updateBranch(Branch branch) {
        if (branch.getBranchId() != null && branchRepository.existsById(branch.getBranchId())) {

            if (branch.getName() == null || branch.getName().isEmpty()) {
                System.out.println("Branch name is missing for update.");
                return null;
            }

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