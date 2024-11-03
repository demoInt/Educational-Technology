package com.edtech.home.dao;

import java.util.List;

import com.edtech.home.entity.CoursesEntity;

public interface HomeDao {

	public List<CoursesEntity> fetchAllCourses();
	
}
