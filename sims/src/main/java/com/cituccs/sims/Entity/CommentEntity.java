package com.cituccs.sims.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_comment")
public class CommentEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int commentId;
	private String comment;

	
//Connect when we have guidePost entity
	
	@ManyToOne
	@JoinColumn(name="username")
	UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="guidepostId")
	GuidepostEntity guidepost;

	public CommentEntity(){}


	public CommentEntity(int commentId, String comment, String test, UserEntity user, GuidepostEntity guidepost) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.user = user;
		this.guidepost = guidepost;
	}


	public int getCommentId() {
		return commentId;
	}

	
	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}
	

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public GuidepostEntity getGuidePost() {
		return guidepost;
	}

	public void setGuidepost(GuidepostEntity guidepost) {
		this.guidepost = guidepost;
	}

}
