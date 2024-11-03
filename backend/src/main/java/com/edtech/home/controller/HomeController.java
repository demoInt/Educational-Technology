package com.edtech.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.home.entity.CoursesEntity;
import com.edtech.home.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/fetchcouses")
	public List<CoursesEntity> fetchAllCourses(){
		return homeService.fetchAllCourses();	
	}
	
	
}
