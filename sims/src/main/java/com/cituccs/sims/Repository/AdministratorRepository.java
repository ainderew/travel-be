package com.cituccs.sims.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.AdministratorEntity;

@Repository
public interface AdministratorRepository  extends  JpaRepository<AdministratorEntity, String>{
	
}
