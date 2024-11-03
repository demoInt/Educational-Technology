package com.edtech.home.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edtech.home.dao.HomeDao;
import com.edtech.home.entity.CoursesEntity;
import com.edtech.home.repository.HomeRepository;

@Repository
public class HomeDaoImpl implements HomeDao {

	@Autowired
	private HomeRepository homeRepository;
	
	@Override
	public List<CoursesEntity> fetchAllCourses() {		
		return homeRepository.findAll();
	}

	

}
