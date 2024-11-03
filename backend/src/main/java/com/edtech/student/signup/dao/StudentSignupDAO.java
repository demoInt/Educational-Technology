package com.edtech.student.signup.dao;

import java.util.Map;

import com.edtech.student.signup.vo.StudentSignupVO;


public interface StudentSignupDAO {

	public Map<String, String> studentSignup(StudentSignupVO vo, String studentId);
	
	boolean emailExists(String email);
	
}