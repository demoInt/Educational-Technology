package com.edtech.student.login.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edtech.student.login.dao.StudentLoginDAO;
import com.edtech.student.login.service.StudentLoginService;
import com.edtech.student.signup.vo.StudentSignupVO;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

    @Autowired
    private StudentLoginDAO studentLoginDAO;
    @Override
    public Map<String, String> verifyLogin(StudentSignupVO studentSignupVO) {
        return studentLoginDAO.verifyLogin(studentSignupVO);
    }
}