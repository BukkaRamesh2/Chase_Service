package com.chase.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chase.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}