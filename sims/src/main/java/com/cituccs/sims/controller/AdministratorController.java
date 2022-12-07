package com.cituccs.sims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cituccs.sims.Entity.AdministratorEntity;
import com.cituccs.sims.Service.AdministratorService;

@RestController
@RequestMapping("/admin")
public class AdministratorController {
	
	@Autowired
	AdministratorService aserv;
	
	@GetMapping("/print")
	public String printHello() {
		return "Hello, Admin!";
	}
	
	@PostMapping("/postAdministrator")
	public AdministratorEntity insertAdministrator(@RequestBody AdministratorEntity administrator) {
		return aserv.insertAdministrator(administrator);
	}
	
	@GetMapping("/displayAllAdministrator")
	public List<AdministratorEntity> getAllAdministrator(){
		return aserv.getAllAdministrator();
	}
	
//	@GetMapping("/getByFavoriteId")
//	public FavoritesEntity findById(@RequestParam int favoriteid) {
//		return fserv.findById(favoriteid);
//	}
	
	@PutMapping("/putAdministrator")
	public AdministratorEntity putAdministrator(@RequestParam String username,@RequestBody AdministratorEntity newAdminDetails) throws Exception{
		return aserv.putAdministrator(username, newAdminDetails);
	}
	
	@DeleteMapping("/deleteAdministator/{username}")
	public String deleteAdministrator(@PathVariable String username){
		return aserv.deleteAdministrator(username);
	}
	
	@GetMapping("/loginAdministrator")
	public boolean checkLoginDetails (@RequestParam String username, String password){
		return aserv.checkLoginDetails(username, password);
	}
}
