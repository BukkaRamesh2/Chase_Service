package com.chase.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chase.entity.Account;

public interface AccountRepository extends JpaRepository<Long, Account>{

}