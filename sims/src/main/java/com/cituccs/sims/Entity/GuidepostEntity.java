package com.cituccs.sims.Entity;


import javax.persistence.Column;

//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_guidepost")
public class GuidepostEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int guidepostid;
	
	private String title;
	@Column(columnDefinition="TEXT")
	private String content;	
	private String photo;
	private boolean isdeleted;
	private String location;
	private Integer views;
	@Column(columnDefinition="TEXT")
	private String dateposted;
	
	@ManyToOne
	@JoinColumn(name="username")
	UserEntity user;
	
	public GuidepostEntity() {}

	public GuidepostEntity(int guidepostid, String title, String content, String photo, boolean isdeleted, UserEntity user, String location, String dateposted) {
		super();
		this.guidepostid = guidepostid;
		this.title = title;
		this.content = content;
		this.isdeleted = isdeleted;
		this.location = location;
		this.dateposted = dateposted;
		this.user = user;
	}

	public int getGuidepostid() {
		return guidepostid;
	}

	public void setGuidepostid(int guidepostid) {
		this.guidepostid = guidepostid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}
	public String getDatePosted() {
		return dateposted;
	}

	public void setDatePosted(String dateposted) {
		this.dateposted = dateposted;
	}

}
