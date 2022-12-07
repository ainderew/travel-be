//package com.travelguide.sims_app.Controller;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cituccs.sims.Entity.GuidepostEntity;
import com.cituccs.sims.Service.GuidepostService;


@RestController
@RequestMapping("/guidepost")
public class GuidepostController {
	
	@Autowired
	GuidepostService gpserv;
	
	//create
	@PostMapping("/postGuidepost")
	public GuidepostEntity insertGuidepost(@RequestBody GuidepostEntity guidepost) {
		return gpserv.insertGuidepost(guidepost);
	}
	
	//read
	@GetMapping("/getAllGuidepost")
	public List<GuidepostEntity> getAllGuidepost(){
		return gpserv.getAllGuidepost();
	}
	
	//read by title
	@GetMapping("/getByTitle")
	public GuidepostEntity findByTitle(@RequestParam String title) {
		return gpserv.findByTitle(title);
	}
	
	//update record
	@PutMapping("/putGuidepost")
	public GuidepostEntity putGuidepost(@RequestParam int guidepostid, GuidepostEntity newGuidepostDetails) throws Exception{
		return gpserv.putGuidepost(guidepostid, newGuidepostDetails);
	};
	
	//delete record
	@DeleteMapping("/deleteGuidepost/{guidepostid}")
	public String deleteGuidepost(@PathVariable int guidepostid) {
		return gpserv.deleteGuidepost(guidepostid);
	}
		
}
