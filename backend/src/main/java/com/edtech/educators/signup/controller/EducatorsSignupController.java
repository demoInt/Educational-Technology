package com.edtech.educators.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.educators.signup.service.EducatorsSignupService;
import com.edtech.educators.signup.vo.EducatorsSignupVO;

@RestController
public class EducatorsSignupController {

	@Autowired
	private EducatorsSignupService educatorsSignupService;
	
	 @PostMapping("/edusignup")
	    public String Signup(Model model,EducatorsSignupVO educatorVo) {
		 String email = educatorVo.getEmail();
		
		 if(educatorsSignupService.findByEmail(email)!=null) {
			 System.out.println("Email already exists in the database");
			return "Email already exists in the database";
		 }else {
		  educatorsSignupService.educatorsSignup(educatorVo);
		 }
		 return "sigin successfull";
		 
	 }
	
}