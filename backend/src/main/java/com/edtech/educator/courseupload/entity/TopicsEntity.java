package com.edtech.educator.courseupload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coursetopics")
public class TopicsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "course_id")
	private String courseId;

	@Column(name = "topic_name")
	private String topicName;

	@Column(name = "video_path")
	private String videoPath;

	@Column(name = "duration")
	private String duration;

	@Column(name = "description")
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "TopicsEntity [id=" + id + ", courseId=" + courseId + ", topicName=" + topicName + ", videoPath="
				+ videoPath + ", duration=" + duration + ", description=" + description + "]";
	}

	public void setDescription(String description) {
		this.description = description;
	}

}