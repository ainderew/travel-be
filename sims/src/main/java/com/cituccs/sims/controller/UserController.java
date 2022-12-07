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

import com.cituccs.sims.Entity.UserEntity;
import com.cituccs.sims.Service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	UserService userv;
	
	@GetMapping("/print")
	public String printHello() {
		return "Hello, User!";
	}
	
	@PostMapping("/postUser")
	public UserEntity insertUser(@RequestBody UserEntity user) {
		return userv.insertUser(user);
	}
	
	@GetMapping("/displayAllUser")
	public List<UserEntity> getAllUser(){
		return userv.getAllUser();
	}
	
//	@GetMapping("/getByUserId")
//	public UserEntity findById(@RequestParam int Userid) {
//		return fserv.findById(Userid);
//	}
	
	@PutMapping("/putUser")
	public UserEntity putUser(@RequestParam String username,@RequestBody UserEntity newUserDetails) throws Exception{
		return userv.putUser(username, newUserDetails);
	}
	
	@DeleteMapping("/deleteUser/{username}")
	public String deleteStudent(@PathVariable String username){
		return userv.deleteUser(username);
	}
	
		@GetMapping("/getUser")
	public UserEntity findByUsername(@RequestParam String username) {
		return userv.findByUsername(username);
	}

	@GetMapping("/loginUser")
	public Boolean loginUser(@RequestBody UserEntity user){
		UserEntity rUser = userv.getUser(user);
		
		String inputPassword = user.getPassword();
		
		String dbPassword = rUser.getPassword();

		if(dbPassword.equals(inputPassword)){
			return true;
		}else{
//			return "inputPassword: " + inputPassword +" dbPassword: " + dbPassword ;
			return false;
				
		}

	}

}
