package com.edtech.student.login.dao;

import java.util.Map;

import com.edtech.student.signup.vo.StudentSignupVO;

public interface StudentLoginDAO {

    Map<String, String> verifyLogin(StudentSignupVO studentSignupVO);
}