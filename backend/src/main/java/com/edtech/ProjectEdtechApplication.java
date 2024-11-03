package com.edtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
//@EnableWebMvc
public class ProjectEdtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectEdtechApplication.class, args);
	}	
	
	@Bean
	 CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(900000000); //900 MB per request
	    return multipartResolver;
	}

}