package com.edtech.educator.courseupload.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edtech.educator.courseupload.dao.CourseUploadDAO;
import com.edtech.educator.courseupload.entity.CourseEntity;
import com.edtech.educator.courseupload.entity.TopicsEntity;
import com.edtech.educator.courseupload.repository.CourseRepository;
import com.edtech.educator.courseupload.repository.TopicsRepository;
import com.edtech.educator.courseupload.vo.CourseBriefVO;
import com.edtech.educator.courseupload.vo.TopicsVO;

@Repository
public class CourseUploadDAOImpl implements CourseUploadDAO {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private TopicsRepository topicsRepository;

	@Override
	@Transactional
	public Map<String, String> uploadCourse(CourseBriefVO vo, String courseId, Integer instructorid) {
		CourseEntity courseEntity = new CourseEntity();
		

		Map<String, String> map = new HashMap<>();

		courseEntity.setName(vo.getTitle());
		courseEntity.setDescription(vo.getDescription());
		courseEntity.setCourseId(courseId);
		courseEntity.setInstructorId(1);
		courseEntity.setDuration(vo.getCourseDuration());
		courseEntity.setPrice(vo.getPrice());
		courseEntity.setVideoPath(vo.getVideoPath());

		System.out.println(courseEntity);
		System.out.println();
		try {
			courseRepository.save(courseEntity);
			map.put("Course saved", courseId);
		} catch (Exception e) {
			System.out.println("An exception occured in course entity: " + e.getMessage());
		}

		List<TopicsVO> list = vo.getTopicsList();
		for (TopicsVO topicsVO : list) {
			TopicsEntity topicsEntity = new TopicsEntity();
			topicsEntity.setCourseId(courseId);
			topicsEntity.setTopicName(topicsVO.getTopicName());
			topicsEntity.setDescription(topicsVO.getTopicDescription());
			topicsEntity.setVideoPath(topicsVO.getVideoPath());
			topicsEntity.setDuration(topicsVO.getDuration());

			System.out.println(topicsEntity);
			System.out.println();

			try {
				topicsEntity = topicsRepository.save(topicsEntity);
				System.out.println(topicsEntity);
				map.put("Topics saved", courseId);
			} catch (Exception e) {
				System.out.println("An exception occured in topic entity: " + e.getMessage());
			}
		}
		return map;
	}
}