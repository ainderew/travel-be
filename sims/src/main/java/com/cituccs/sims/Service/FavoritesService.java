package com.cituccs.sims.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.FavoritesEntity;
import com.cituccs.sims.Entity.GuidepostEntity;
import com.cituccs.sims.Entity.UserEntity;
import com.cituccs.sims.Repository.FavoritesRepository;

@Service
public class FavoritesService {

	@Autowired
	FavoritesRepository frepo;
	
	public FavoritesEntity putFavorites(int favoritesid, FavoritesEntity newFavoriteDetails) throws Exception{
		FavoritesEntity favorites = new FavoritesEntity();
		
		try {
			favorites = frepo.findById(favoritesid).get();
			favorites.setStatus(newFavoriteDetails.isStatus());
			return frepo.save(favorites);
		}catch(NoSuchElementException nex) {
			throw new Exception("ID Number "+ favoritesid +" does not exist!");
		}
		
	}
	
	public String deleteFavorites(int favoritesid) {
		String msg;
		if(frepo.findById(favoritesid) !=null) {
			frepo.deleteById(favoritesid);
			msg = "ID Number " + favoritesid + " is successfully deleted!";
		}else 
			msg = "ID Number " + favoritesid + " is NOT found!";
		
		return msg;
	}
	
	public FavoritesEntity insertFavorites(FavoritesEntity favorites) {
		return frepo.save(favorites);
	}
	
	public List<FavoritesEntity> getAllFavorites(){
		return frepo.findAll();
	}
	
	
	public List<FavoritesEntity> findByUsername(UserEntity username){
		if(frepo.findByUser(username) !=null)
			return frepo.findByUser(username);
		else
			return null;
	}

	public FavoritesEntity toggleFavorite(UserEntity username, GuidepostEntity guidepostid){
		FavoritesEntity favorites = new FavoritesEntity();
		
		if(frepo.findByUserAndGuidepostid(username, guidepostid)!=null) {
			favorites = frepo.findByUserAndGuidepostid(username, guidepostid);
			favorites.setStatus(!favorites.isStatus());
			return frepo.save(favorites);
		}else {
			favorites.setStatus(true);
			favorites.setUser(username);
			favorites.setGuidepostid(guidepostid);
			return frepo.save(favorites);
		}
	}
	
	public FavoritesEntity findFavorite(UserEntity user, GuidepostEntity guidepostid) {
		if(frepo.findByUserAndGuidepostid(user, guidepostid)!=null)
			return frepo.findByUserAndGuidepostid(user, guidepostid);
		else return null;
	}
	
	public List<FavoritesEntity> findByUserAndStatus(UserEntity username){
		if(frepo.findByUserAndStatus(username, true) !=null)
			return frepo.findByUserAndStatus(username, true);
		else
			return null;
	}

}
