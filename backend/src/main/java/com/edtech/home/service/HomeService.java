package com.edtech.home.service;

import java.util.List;

import com.edtech.home.Vo.CoursesVo;
import com.edtech.home.entity.CoursesEntity;

public interface HomeService {

	public List<CoursesEntity> fetchAllCourses();
	
}
