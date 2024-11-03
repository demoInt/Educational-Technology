package com.edtech.student.signup.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.student.signup.service.StudentSignupService;
import com.edtech.student.signup.vo.StudentSignupVO;

@RestController
@RequestMapping("/student")
public class StudentSignupController {

    @Autowired
    private StudentSignupService service;

	/* End point which handles the student sign up process. Saves the data into the database and 
	   returns home page if successful */

    @PostMapping("/signup")
    public Map<String, String> studentSignUp(Model model, StudentSignupVO vo, HttpServletRequest request) {
    	System.out.println("Welcome to Signup\n");
  
    	System.out.println(vo.getEmail());
    	System.out.println(vo.getName());
    	System.out.println(vo.getPassword());
        Map<String, String> res = service.studentSignup(vo);
        if (res != null && res.containsKey("saved")) {
        	HttpSession session = request.getSession();
        	session.setAttribute("studentId", res.get("studentId"));
            return res;
        }
        return res;
    }
}