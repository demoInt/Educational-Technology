package com.edtech.home.Vo;

import java.sql.Timestamp;

public class CoursesVo {

	private String name;
	private String description;
	private Integer instrectorId;
	private double price;
	private double duration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getInstrectorId() {
		return instrectorId;
	}
	public void setInstrectorId(Integer instrectorId) {
		this.instrectorId = instrectorId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
}
