package com.edtech.student.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edtech.student.signup.entity.StudentSignupEntity;

public interface StudentSignupRepository extends JpaRepository<StudentSignupEntity, Integer> {
	
    @Query("SELECT S FROM StudentSignupEntity S WHERE S.email = :email")
    StudentSignupEntity emailExists(@Param("email") String email);
}