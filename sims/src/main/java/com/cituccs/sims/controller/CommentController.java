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
import org.springframework.web.bind.annotation.RestController;

import com.cituccs.sims.Entity.CommentEntity;
import com.cituccs.sims.Service.CommentService;


@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	CommentService cserv;
	
	@GetMapping("/test")
	public String printHelloWorld() {
		return "This is the comment route";
	}
	
	@PostMapping("/createComment")
	public String createComment(@RequestBody CommentEntity comment) {
		if(cserv.createComment(comment) == "Success") {
			return "Success";
		}
		return "Error";
	}
	
	@GetMapping("/getAllComments")
	public List<CommentEntity> getAllComments(){
		return cserv.getAllComments();
	}
	
	@PutMapping("/updateComment/{commentId}")
	public String updateComment(@PathVariable int commentId, @RequestBody CommentEntity newComment ) {
		
		if(cserv.updateComment(commentId, newComment) == "Success") {
			return "Success";
		}
		return "Error";
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	public String deleteComment(@PathVariable int commentId){
		return cserv.deleteComment(commentId);
	}
}
