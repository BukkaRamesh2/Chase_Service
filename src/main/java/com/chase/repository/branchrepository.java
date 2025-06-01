package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Branch;

@Repository
public interface branchrepository extends JpaRepository<Branch,Long>{

}
