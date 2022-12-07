package com.cituccs.sims.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.UserEntity;
import com.cituccs.sims.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository urepo;
	
	public UserEntity putUser(String username, UserEntity newUserDetails) throws Exception{
		UserEntity user = new UserEntity();
		
		try {
			user = urepo.findById(username).get();
			user.setPassword(newUserDetails.getPassword());
			user.setName(newUserDetails.getName());
			user.setPhoneNumber(newUserDetails.getPhoneNumber());
			user.setEmail(newUserDetails.getEmail());
			return urepo.save(user);
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
	
	public List<UserEntity> getAllUser(){
		return urepo.findAll();
	}

	public UserEntity getUser(UserEntity user){
		String uName = user.getUsername();
		return urepo.findById(uName).get();
	}
	
	public UserEntity findByUsername(String username) {
		return urepo.findById(username).get();
	}
	
//	public UserEntity findById(int id) {
//		if(srepo.findByFirstname(firstname) !=null)
//			return srepo.findByFirstname(firstname);
//		else
//			return null;
//	}


}
