package com.edtech.student.signup.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.edtech.student.signup.dao.StudentSignupDAO;
import com.edtech.student.signup.entity.StudentSignupEntity;
import com.edtech.student.signup.repository.StudentSignupRepository;
import com.edtech.student.signup.vo.StudentSignupVO;

@Repository
public class StudentSignupDAOImpl implements StudentSignupDAO {

	@Autowired
	public StudentSignupRepository repo;

	@Override
	public Map<String, String> studentSignup(StudentSignupVO vo, String userId) {
		StudentSignupEntity entity = new StudentSignupEntity();
		Map<String, String> map = new HashMap<>();
		entity.setEmail(vo.getEmail());
		entity.setUserId(userId);
		entity.setName(vo.getName());
		entity.setPassword(BCrypt.hashpw(vo.getPassword(), BCrypt.gensalt(12)));
		try {
			repo.save(entity);
			map.put("studentId", userId);
			return map;
		} catch (DataIntegrityViolationException e) {
			if (e.getCause() instanceof SQLException sqlException) {
				if (sqlException.getErrorCode() == 2627 || sqlException.getErrorCode() == 2601) {
					// Unique constraint violation error
					String msg = "A unique constraint violation occurred: " + sqlException.getMessage();
					map.put("failed", "failed to save");
				}
			}
			e.printStackTrace();
			return map;
		}
	}

	@Override
	public boolean emailExists(String email) {
		StudentSignupEntity studentSignupEntity = repo.emailExists(email);
		return studentSignupEntity != null;
	}
}