package com.cituccs.sims.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.CommentEntity;
import com.cituccs.sims.Repository.CommentRepository;


@Service
public class CommentService {
	
	@Autowired
	CommentRepository crepo;
	
// FOR POSTING COMMENTS TO GUIDEPOST
	
	public String deleteComment(int commentId) {
		String msg;
		if(crepo.findById(commentId) !=null) {
			crepo.deleteById(commentId);
			msg = "Comment ID Number " + commentId + " is successfully deleted!";
		}else 
			msg = "Comment ID Number " + commentId + " is NOT found!";
		
		return msg;
	}
	
	public String createComment(CommentEntity newComment) {
		try {
			crepo.save(newComment);
			return "Success";
			
		}catch(IllegalArgumentException err) {
			return "Error";
		}
	}
	
	public List<CommentEntity> getAllComments(){
		return crepo.findAll();
	}
	
	public String updateComment(int commentId, CommentEntity newComment) {
		try {
			CommentEntity comment = crepo.findById(commentId).get();
			comment.setComment(newComment.getComment());
			crepo.save(comment);
			return "Success";
		}catch(NoSuchElementException err) {
			return "Error";
		}
	}
}
