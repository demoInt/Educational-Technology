package com.edtech.educators.signup.dao;

import com.edtech.educators.signup.entity.EducatorsSignupEntity;
import com.edtech.educators.signup.vo.EducatorsSignupVO;

public interface EducatorsSignupDAO {

	public String educatorsSignup(EducatorsSignupVO educatorVo);
	
	public EducatorsSignupEntity findByEmail(String email);

}
