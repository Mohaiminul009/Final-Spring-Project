package com.spring.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.spring.main.service.CourseFileService;

@SpringBootApplication
public class VSchoolApplication extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private CourseFileService courseFileService;
	
	public static void main(String[] args) {
		SpringApplication.run(VSchoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseFileService.init();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VSchoolApplication.class);
	}

}
