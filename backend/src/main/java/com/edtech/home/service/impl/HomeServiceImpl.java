package com.edtech.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.home.dao.HomeDao;
import com.edtech.home.entity.CoursesEntity;
import com.edtech.home.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	private HomeDao homeDao;
	
	@Override
	public List<CoursesEntity> fetchAllCourses(){ 	
		return homeDao.fetchAllCourses();
	}

	

}
