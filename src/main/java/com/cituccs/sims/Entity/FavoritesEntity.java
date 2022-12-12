package com.cituccs.sims.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_favorites")
public class FavoritesEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int favoriteid;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="username")
	UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="guidepostid")
	GuidepostEntity guidepostid;
	
	public FavoritesEntity() {}

	public FavoritesEntity(int favoriteid, boolean status, UserEntity user/*, GuidepostEntity guidepostid */) {
		super();
		this.favoriteid = favoriteid;
		this.status = status;
		this.user = user;
		this.guidepostid = guidepostid;
	}

	public int getFavoriteid() {
		return favoriteid;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public GuidepostEntity getGuidepostid() {
		return guidepostid;
	}

	public void setGuidepostid(GuidepostEntity guidepostid) {
		this.guidepostid = guidepostid;
	}
	
}
