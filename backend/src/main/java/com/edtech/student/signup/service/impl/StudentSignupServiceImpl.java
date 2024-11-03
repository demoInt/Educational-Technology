package com.edtech.student.signup.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.student.signup.dao.StudentSignupDAO;
import com.edtech.student.signup.service.StudentSignupService;
import com.edtech.student.signup.vo.StudentSignupVO;

@Service
public class StudentSignupServiceImpl implements StudentSignupService{

	@Autowired
	public StudentSignupDAO dao;
	
	@Override
	public Map<String, String> studentSignup(StudentSignupVO vo) {
		Map<String, String> map = new HashMap<>();
		boolean emailCheck = emailExists(vo.getEmail());
		if(!emailCheck) {
			String userid = generateUserId();
			Map<String, String> res = dao.studentSignup(vo, userid);
		}else {
			map.put("email-exists", vo.getEmail()+" already exists, Please go to Login.");
		}	
		return map;	
	}
	
	private String generateUserId() {
		// Can also use snowflake, twitter snowflake and Apache commons-id
		String res = UUID.randomUUID().toString();
		res = res.replace("-", "");
		return res.substring(0, 7);
	}

	private boolean emailExists(String email) {
		return dao.emailExists(email);
	}
	
}