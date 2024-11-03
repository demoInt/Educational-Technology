package com.edtech.educators.signup.service;

import com.edtech.educators.signup.entity.EducatorsSignupEntity;
import com.edtech.educators.signup.vo.EducatorsSignupVO;

public interface EducatorsSignupService {

	public String educatorsSignup(EducatorsSignupVO educatorVo);
	
	 public EducatorsSignupEntity findByEmail(String email);

	
	
}
