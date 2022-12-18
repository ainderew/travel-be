package com.cituccs.sims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cituccs.sims.Entity.FavoritesEntity;
import com.cituccs.sims.Entity.GuidepostEntity;
import com.cituccs.sims.Entity.UserEntity;
import com.cituccs.sims.Service.FavoritesService;
import com.cituccs.sims.Service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/favorites")
public class FavoritesController {


	@Autowired
	FavoritesService fserv;
	@Autowired
	UserService userv;
	
	@GetMapping("/print")
	public String printHello() {
		return "Hello, User!";
	}
	
	@PostMapping("/postFavorites")
	public FavoritesEntity insertFavorites(@RequestBody FavoritesEntity favorites) {
		return fserv.insertFavorites(favorites);
	}
	
	@GetMapping("/displayAllFavorites")
	public List<FavoritesEntity> getAllFavorites(){
		return fserv.getAllFavorites();
	}
	
	@PutMapping("/putFavorites")
	public FavoritesEntity putFavorites(@RequestParam int id,@RequestBody FavoritesEntity newFavoriteDetails) throws Exception{
		return fserv.putFavorites(id, newFavoriteDetails);
	}
	
	@DeleteMapping("/deleteFavorites/{id}")
	public String deleteFavorites(@PathVariable int id){
		return fserv.deleteFavorites(id);
	}
	
	@GetMapping("/getAllUserFavorites")
	public List<FavoritesEntity> findByUsername(@RequestParam UserEntity username){
		return fserv.findByUsername(username);
	}
	
	
	
	@PutMapping("/toggleFavorite")
	public FavoritesEntity toggleFavorite(@RequestParam UserEntity username, GuidepostEntity guidepostid){
		return fserv.toggleFavorite(username, guidepostid);
	}
	
	@GetMapping("/getFavorite")
	public FavoritesEntity findFavorite(@RequestParam UserEntity username, GuidepostEntity guidepostid){
		return fserv.findFavorite(username, guidepostid);
	}
	
	@GetMapping("/getUserFavorites")
	public List<FavoritesEntity> findByUserAndStatus(@RequestParam UserEntity username){
		return fserv.findByUserAndStatus(username);
	}
}
