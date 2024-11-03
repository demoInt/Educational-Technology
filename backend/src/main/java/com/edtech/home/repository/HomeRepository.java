package com.edtech.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edtech.home.entity.CoursesEntity;

public interface HomeRepository extends JpaRepository<CoursesEntity, Integer>{

}
