package com.cituccs.sims.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.FavoritesEntity;
import com.cituccs.sims.Entity.GuidepostEntity;
import com.cituccs.sims.Entity.UserEntity;
import com.cituccs.sims.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository urepo;
	
	public UserEntity putUser(UserEntity user) throws Exception{
		try {
			UserEntity e_User = urepo.findById(user.getUsername()).get();
			e_User.setName(user.getName());
			e_User.setPhoneNumber(user.getPhoneNumber());
			e_User.setEmail(user.getEmail());
			return urepo.save(e_User);
		}catch(NoSuchElementException nex) {
			throw new Exception("Username "+ user +" does not exist!");
		}
		
	}
	
	public String deleteUser(String username) {
		String msg;
		if(urepo.findById(username) !=null) {
			urepo.deleteById(username);
			msg = "Username " + username + " is successfully deleted!";
		}else 
			msg = "Username " + username + " is NOT found!";
		
		return msg;
	}
	
	public UserEntity insertUser(UserEntity user) {
		return urepo.save(user);
	}
	
	public UserEntity getUser(UserEntity user){
		String uName = user.getUsername();
		return urepo.findById(uName).get();
	}
	
	public UserEntity findByUsername(String username) {
		return urepo.findById(username).get();
	}
	
	public List<UserEntity> getAllUser(){
		return urepo.findAll();
	}
	
	public UserEntity toggleStatInactive(UserEntity username){
		username.setBanned(false);
		return urepo.save(username);
	}
	
	public UserEntity toggleStatActive(UserEntity username){
		username.setBanned(true);
		return urepo.save(username);
	}
	
}
