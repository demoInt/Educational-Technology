package com.edtech.educators.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edtech.educators.signup.entity.EducatorsSignupEntity;

public interface EducatorsSignupRepository extends JpaRepository<EducatorsSignupEntity, Integer> {


	public EducatorsSignupEntity findByEmail(String email);


}
