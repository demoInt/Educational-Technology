package com.edtech.student.login.service;

import java.util.Map;

import com.edtech.student.signup.vo.StudentSignupVO;


public interface StudentLoginService {
    public Map<String, String> verifyLogin(StudentSignupVO studentSignupVO);
}
