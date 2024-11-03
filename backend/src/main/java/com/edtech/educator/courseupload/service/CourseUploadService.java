package com.edtech.educator.courseupload.service;

import java.util.Map;

import com.edtech.educator.courseupload.vo.CourseBriefVO;

public interface CourseUploadService {
	
	Map<String, String> uploadCourse(CourseBriefVO vo,Integer instructorid);

}
