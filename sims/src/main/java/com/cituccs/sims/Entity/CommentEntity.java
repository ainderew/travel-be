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
	private String test;
//	private GuidepostEntity guidepost;

	
//Connect when we have guidePost entity
	
//	@ManyToOne
//	@JoinColumn(name="id")
//	GuidepostEntity guidepost;
	
//	@ManyToOne
//	@JoinColumn(name="id")
//	UserEntity user;

	public CommentEntity(){}


	public CommentEntity(int commentId, String comment, String test) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.test = test;
	}


	public int getCommentId() {
		return commentId;
	}


	public void setTest(String test) {
		this.test = test;
	}

	
	public String getComment() {
		return comment;
	}


	public void setComment(String description) {
		this.comment = description;
	}
	


	@Override
	public String toString() {
		return "CommentEntity [commentID:" + commentId + ", comment:" + comment +"]";
	}

}
