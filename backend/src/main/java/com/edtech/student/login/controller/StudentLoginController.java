package com.edtech.student.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.student.login.service.StudentLoginService;
import com.edtech.student.signup.vo.StudentSignupVO;

@RestController
@RequestMapping("/student")
public class StudentLoginController {

    @Autowired
    private StudentLoginService studentLoginService;

    @PostMapping("/login")
    public Map<String, String> loginStudent(StudentSignupVO  studentSignupVO){
    	System.out.println(studentSignupVO.getEmail());
    	System.out.println(studentSignupVO.getPassword());
        return   studentLoginService.verifyLogin(studentSignupVO);
    }
}