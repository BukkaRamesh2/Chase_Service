package com.chase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Insurance;

@Repository
public interface Insurancerepository extends JpaRepository<Insurance, Long>{

}
