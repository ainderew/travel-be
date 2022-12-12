package com.cituccs.sims.Service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.AdministratorEntity;
import com.cituccs.sims.Repository.AdministratorRepository;

@Service
public class AdministratorService {
	
	@Autowired
	AdministratorRepository arepo;
	
	public AdministratorEntity putAdministrator(String username, AdministratorEntity newAdminDetails) throws Exception{
		AdministratorEntity admin = new AdministratorEntity();
		
		try {
			admin = arepo.findById(username).get();
			admin.setPassword(newAdminDetails.getPassword());
			return arepo.save(admin);
		}catch(NoSuchElementException nex) {
			throw new Exception("Username "+ username +" does not exist!");
		}
		
	}
	
	public String deleteAdministrator(String username) {
		String msg;
		if(arepo.findById(username) !=null) {
			arepo.deleteById(username);
			msg = "Username " + username + " is successfully deleted!";
		}else 
			msg = "Username " + username + " is NOT found!";
		
		return msg;
	}
	
	public AdministratorEntity insertAdministrator(AdministratorEntity admin) throws Exception{
		
		try {
			arepo.findById(admin.getUsername()).get();
			throw new Exception("Username "+ admin.getUsername() +" already exist!");
		}catch(NoSuchElementException nex) {
			return arepo.save(admin);
		}
		
	}
	
	public List<AdministratorEntity> getAllAdministrator(){
		return arepo.findAll();
	}
	
	public boolean checkLoginDetails(String username, String password) {
		AdministratorEntity admin = new AdministratorEntity();
	
		if(arepo.findById(username) !=null){
			admin = arepo.findById(username).get();
			if(admin.getPassword().equals(password)) 
				return true;
			else
				return false;
		}else
			return false; 
	}
	
	
}
