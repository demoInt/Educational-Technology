package com.edtech.educator.courseupload.vo;

import org.springframework.web.multipart.MultipartFile;

public class TopicsVO {

	private String topicName;
	private String topicDescription;
	private MultipartFile topicVideo;
	private String videoPath;
	private String duration;

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTopicName() {
		return topicName;
	} 

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	public MultipartFile getTopicVideo() {
		return topicVideo;
	}

	public void setTopicVideo(MultipartFile topicVideo) {
		this.topicVideo = topicVideo;
	}

	@Override
	public String toString() {
		return "TopicsVO [topicName=" + topicName + ", topicDescription=" + topicDescription + ", topicVideo="
				+ topicVideo + ", videoPath=" + videoPath + ", duration=" + duration + "]";
	}

	public String getVideoPath() {	
		return videoPath;
	}
	
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

}