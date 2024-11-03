package com.edtech.student.login.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edtech.student.login.dao.StudentLoginDAO;
import com.edtech.student.signup.entity.StudentSignupEntity;
import com.edtech.student.signup.repository.StudentSignupRepository;
import com.edtech.student.signup.vo.StudentSignupVO;

@Repository
public class StudentLoginDAOImpl implements StudentLoginDAO {

	@Autowired
	private StudentSignupRepository studentSignupRepository;

	@Override
	public Map<String, String> verifyLogin(StudentSignupVO studentSignupVO) {
		Map<String, String> map = new HashMap<String, String>();
		StudentSignupEntity studentSignupEntity = studentSignupRepository.emailExists(studentSignupVO.getEmail());
//		System.out.println(studentSignupEntity.getPassword());

		if (studentSignupEntity != null && studentSignupEntity.getEmail().equals(studentSignupVO.getEmail())
				&& BCrypt.checkpw(studentSignupVO.getPassword(),studentSignupEntity.getPassword())) {
			map.put("verified", "Credentials checked out");
			map.put("userid", studentSignupEntity.getUserId());
		} else if (studentSignupEntity == null) {
			map.put("email-message", "Please check your email");
		} else {
			map.put("password-message", "Please check your password");
		}

		return map;
	}
}