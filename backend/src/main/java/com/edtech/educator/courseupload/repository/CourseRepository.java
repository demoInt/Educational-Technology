package com.edtech.educator.courseupload.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edtech.educator.courseupload.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{

}
