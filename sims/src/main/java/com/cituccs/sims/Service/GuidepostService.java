package com.cituccs.sims.Service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cituccs.sims.Entity.GuidepostEntity;
import com.cituccs.sims.Repository.GuidepostRepository;

@Service
public class GuidepostService {

	@Autowired
	GuidepostRepository grepo;
	
	//create/insert
	public GuidepostEntity insertGuidepost(GuidepostEntity guide) {
		return grepo.save(guide);
	}
	
	//Read
	public List<GuidepostEntity> getAllGuidepost(){
		return grepo.findAll();
	}
	
	//read by title
	public GuidepostEntity findByTitle(String title) { 
		if (grepo.findByTitle(title) != null)
			return grepo.findByTitle(title); 
		else
			return null;
	}
	
	//update
	public GuidepostEntity putGuidepost(int guidepostid, GuidepostEntity newGuidepostDetails) throws Exception{
		GuidepostEntity guidepost = new GuidepostEntity();
		try {
			//search
			guidepost = grepo.findById(guidepostid).get();
			
			//update
			guidepost.setTitle(newGuidepostDetails.getTitle());
			guidepost.setContent(newGuidepostDetails.getContent());
			guidepost.setIsdeleted(newGuidepostDetails.getIsdeleted());
			
			//save and return the value
			return grepo.save(guidepost);
		}catch(NoSuchElementException nex) {
			throw new Exception("The guide does not exist!");
		}
	}
	
	//Delete
		public String deleteGuidepost(int guidepostid) {
			String msg;
			if(grepo.findById(guidepostid) != null) {     //find
				grepo.deleteById(guidepostid);            //delete
				msg = "The posted guide is successfully deleted!";
			}
			else
				msg = "The posted guide is NOT found!";
			return msg;
		}
}
