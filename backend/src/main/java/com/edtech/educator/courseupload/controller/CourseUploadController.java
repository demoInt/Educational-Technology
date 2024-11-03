package com.edtech.educator.courseupload.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edtech.educator.courseupload.service.CourseUploadService;
import com.edtech.educator.courseupload.vo.CourseBriefVO;

@RestController
@RequestMapping("/educator")
public class CourseUploadController {

	@Autowired
	private CourseUploadService courseUploadService;

	@PostMapping("/submit_course")
	public Map<String, String> uploadCourse(@ModelAttribute CourseBriefVO vo, HttpServletRequest req, Model model) {
//		System.out.println(vo);

		HttpSession session = req.getSession();
		Integer instructorId = (Integer) session.getAttribute("instructorId");

		Map<String, String> result = courseUploadService.uploadCourse(vo, instructorId);

		model.addAttribute(result);

		return result;
	}
}