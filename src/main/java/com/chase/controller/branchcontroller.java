package com.chase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.chase.entity.Branch;
import com.chase.util.Jwtutil;
import com.chase.service.branchservice;

@RestController
@RequestMapping("/branch")  
public class branchcontroller {

    @Autowired
    private branchservice branchService;

    @Autowired
    private Jwtutil jwtUtil; 

    
    @PostMapping("/userlogin")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "admin123".equals(password)) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid Credentials");
        }
    }

    
    @PostMapping("/addBranch")
    public Branch addBranch(@RequestBody Branch branch) {
        return branchService.addBranch(branch);
    }

    
    @GetMapping("/getBranch/{branchId}")
    public Branch getBranch(@PathVariable int branchId) {
        return branchService.getBranch(branchId);
    }

    
    @GetMapping("/getallBranches")
    public List<Branch> getAllBranches() {
        return branchService.getallBranchs();
    }

    
    @PutMapping("/updateBranch")
    public Branch updateBranch(@RequestBody Branch branch) {
        return branchService.updateBranch(branch);
    }

    
    @DeleteMapping("/deleteBranch/{branchId}")
    public Branch deleteBranch(@PathVariable int branchId) {
        return branchService.deleteBranch(branchId);
    }
}
