package com.cituccs.sims.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.UserEntity;

@Repository
public interface UserRepository  extends  JpaRepository<UserEntity, String>{
	
//	UserEntity findByUsername(String username);
}

