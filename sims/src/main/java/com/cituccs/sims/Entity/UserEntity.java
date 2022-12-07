package com.cituccs.sims.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbl_user")
public class UserEntity {
	
	@Id
	private String username;
	
	private String password;
	private String name;
	private String phoneNumber;
	private String email;
	private boolean isBanned;
	
	
	public UserEntity(){}


	public UserEntity(String username, String password, String name, String phoneNumber, String email,
			boolean isBanned) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isBanned = isBanned;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isBanned() {
		return isBanned;
	}


	public void setBanned(boolean isBanned) {
		this.isBanned = isBanned;
	}
	
}
