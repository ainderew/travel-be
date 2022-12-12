//package com.travelguide.sims_app.Entity;
package com.cituccs.sims.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admin")
public class AdministratorEntity {
	
	@Id
	private String username;
	
	private String password;
	
	public AdministratorEntity(){}

	public AdministratorEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
}
