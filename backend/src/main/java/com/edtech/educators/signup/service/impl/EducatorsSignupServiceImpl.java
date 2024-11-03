package com.edtech.educators.signup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.educators.signup.dao.EducatorsSignupDAO;
import com.edtech.educators.signup.entity.EducatorsSignupEntity;
import com.edtech.educators.signup.service.EducatorsSignupService;
import com.edtech.educators.signup.vo.EducatorsSignupVO;

@Service
public class EducatorsSignupServiceImpl implements EducatorsSignupService{

	@Autowired
	public EducatorsSignupDAO educatorsSignupDAO;
	
	@Override
	public String educatorsSignup(EducatorsSignupVO educatorVo) {	
		return educatorsSignupDAO.educatorsSignup(educatorVo);
	}
	
	@Override
	 public EducatorsSignupEntity findByEmail(String email) {
	        return educatorsSignupDAO.findByEmail(email);
	    }
	
}