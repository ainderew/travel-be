package com.cituccs.sims.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cituccs.sims.Entity.FavoritesEntity;
import com.cituccs.sims.Entity.UserEntity;

@Repository
public interface FavoritesRepository  extends JpaRepository<FavoritesEntity, Integer>{

	List<FavoritesEntity> findByUser(UserEntity username);
	
}
