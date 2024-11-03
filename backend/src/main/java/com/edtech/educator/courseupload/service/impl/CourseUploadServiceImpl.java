package com.edtech.educator.courseupload.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.edtech.educator.courseupload.dao.CourseUploadDAO;
import com.edtech.educator.courseupload.service.CourseUploadService;
import com.edtech.educator.courseupload.vo.CourseBriefVO;
import com.edtech.educator.courseupload.vo.TopicsVO;

@Service
public class CourseUploadServiceImpl implements CourseUploadService {

	@Autowired
	private CourseUploadDAO dao;

	Double totalDuration = 0.0;

	@Override
	public Map<String, String> uploadCourse(CourseBriefVO vo, Integer instructorid) {
		String courseId = generateCourseId();
		createFoldersForCourse(vo);
		return dao.uploadCourse(vo, courseId, instructorid);
	}

	private void createFoldersForCourse(CourseBriefVO vo) {

		// storing the introduction video of the course

		String introVideoPath = "Course Content/" + vo.getTitle() + "/" + "intro video" + "/";
		String pathToCheckDuration = introVideoPath + vo.getVideo().getOriginalFilename();
		MultipartFile introVideo = vo.getVideo();
		try {
			File introVideoDir = new File(introVideoPath);
			if (!introVideoDir.exists()) {
				introVideoDir.mkdirs();
			}
			File introVideoFile = new File(introVideoDir, introVideo.getOriginalFilename());
			introVideo.transferTo(introVideoFile);
			vo.setIntroVideoDuration(getVideoDuration(introVideoPath));
			vo.setVideoPath(introVideoPath);
		} catch (IllegalStateException e) {
			System.out.println("An exception occured: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An exception occured in course: " + e.getMessage());
		}

		// storing topic wise videos

		List<TopicsVO> list = vo.getTopicsList();
		for (TopicsVO topicsVO : list) {
			String topicVideoPath = "Course Content/" + vo.getTitle() + "/" + "topics/" + topicsVO.getTopicName() + "/";
			MultipartFile topicVideo = topicsVO.getTopicVideo();
			try {
				File topicVideoDir = new File(topicVideoPath);
				if (!topicVideoDir.exists()) {
					topicVideoDir.mkdirs();
				}
				File topicVideoFile = new File(topicVideoDir, topicVideo.getOriginalFilename());
				topicVideo.transferTo(topicVideoFile);
				topicsVO.setDuration(getVideoDuration(introVideoPath));
				topicsVO.setVideoPath(topicVideoPath);
				String pathToCheckDurationOfTopicVideo = topicVideoPath + topicVideo.getOriginalFilename();
				String duration = getVideoDuration(pathToCheckDurationOfTopicVideo);
				topicsVO.setDuration(duration);
				calcTotalDuration(duration);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		vo.setCourseDuration(String.valueOf(totalDuration));
	}

	private void calcTotalDuration(String duration) {
		Double doubleDuration = Double.parseDouble(duration);
		totalDuration = totalDuration + doubleDuration;
//		System.out.println("Total Duration: " + doubleDuration);
	}

	private String generateCourseId() {
		String res = UUID.randomUUID().toString();
		res = res.replace("-", "");
		return res.substring(0, 7);
	}

	public static String getVideoDuration(String videoPath) throws IOException {
		String[] cmd = { "ffmpeg", "-i", videoPath };
		Process process = Runtime.getRuntime().exec(cmd);

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String line;
		String duration = " ";

		while ((line = reader.readLine()) != null) {
			if (line.contains("Duration:")) {
				String[] durationParts = line.split(",");
				String durationStr = durationParts[0];
//				System.out.println(durationStr);
				duration = parseDuration(durationStr);
//				System.out.println("duration in seconds = " + duration);
			}
		}
		return duration;
	}

	private static String parseDuration(String durationStr) {
		String[] durationParts = durationStr.split(":");
//		System.out.println("durationParts: " + Arrays.toString(durationParts));
		double hours = Double.parseDouble(durationParts[1]);
		double minutes = Double.parseDouble(durationParts[2]);
		double seconds = Double.parseDouble(durationParts[3].substring(0, durationParts[3].indexOf(".")));
		return String.valueOf(hours * 3600 + minutes * 60 + seconds);
	}

}