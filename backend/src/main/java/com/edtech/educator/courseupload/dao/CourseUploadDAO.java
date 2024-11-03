package com.edtech.educator.courseupload.dao;

import java.util.Map;

import com.edtech.educator.courseupload.vo.CourseBriefVO;

public interface CourseUploadDAO {
	
	Map<String, String> uploadCourse(CourseBriefVO vo, String courseId, Integer instructorid);
	
}

