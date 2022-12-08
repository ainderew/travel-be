package com.cituccs.sims.Entity;


//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//	private String photo;
	private boolean isdeleted;
	
	public GuidepostEntity() {}
	
	//@ManyToOne(cascade = CascadeType.MERGE)
	//private Set<UserEntity> username;

	public GuidepostEntity(int guidepostid, String title, String content, boolean isdeleted /*, Set<UserEntity> username*/) {
		super();
		this.guidepostid = guidepostid;
		this.title = title;
		this.content = content;
		this.isdeleted = isdeleted;
		//this.username = username;
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

	//public Set<UserEntity> getUser() {
	//	return username;
	//}

	//public void setUser(Set<UserEntity> username) {
	//	this.username = username;
	//}

}
