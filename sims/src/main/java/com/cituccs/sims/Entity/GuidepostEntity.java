package com.cituccs.sims.Entity;


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
	private String content;
	private String photo;
	private boolean isdeleted;
	
	@ManyToOne
	@JoinColumn(name="username")
	UserEntity user;
	
	public GuidepostEntity() {}

	public GuidepostEntity(int guidepostid, String title, String content, String photo, boolean isdeleted, UserEntity user) {
		super();
		this.guidepostid = guidepostid;
		this.title = title;
		this.content = content;
		this.isdeleted = isdeleted;
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


}
