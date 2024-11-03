package com.edtech.educators.signup.dao.impl;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edtech.educators.signup.dao.EducatorsSignupDAO;
import com.edtech.educators.signup.entity.EducatorsSignupEntity;
import com.edtech.educators.signup.repository.EducatorsSignupRepository;
import com.edtech.educators.signup.vo.EducatorsSignupVO;

@Repository
public class EducatorsSignupDAOImpl implements EducatorsSignupDAO{

	@Autowired
	private EducatorsSignupRepository educatorsSignupRepository;
	
	@Override
	public String educatorsSignup(EducatorsSignupVO educatorVo) {
		
		EducatorsSignupEntity edu = new EducatorsSignupEntity();
		
		edu.setFirstName(educatorVo.getFirstName());
		edu.setLastName(educatorVo.getLastName());
		edu.setEmail(educatorVo.getEmail());
		edu.setPassword(BCrypt.hashpw(educatorVo.getPassword(), BCrypt.gensalt()));
		edu.setBio(educatorVo.getBio());
		
			educatorsSignupRepository.save(edu);
			return "Success";

	}

	@Override
	 public EducatorsSignupEntity findByEmail(String email) {
        return educatorsSignupRepository.findByEmail(email);
    }


	

	
	

	
}