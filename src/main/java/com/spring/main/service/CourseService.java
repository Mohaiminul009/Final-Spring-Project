package com.spring.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.entity.Course;
import com.spring.main.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public Course post(Course course) {
		if (!course.equals(null)) {
			return courseRepository.save(course);
		}
		return null;
	}
	
	public List<Course> getAll() {
		return courseRepository.findAll();
	}
	
	public Course getById(int id) {
		Optional<Course> optional = courseRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}	
		return null;
	}
	
//	public Course update(Course course) {
//		Optional<Course> optional = courseRepository.findById(course.getCourseId());
//		if (optional.isPresent()) {
//			return optional.get();
//		}
//		return courseRepository.save(course);
//	}
	
	public String delete(int id) {
		Optional<Course> optional = courseRepository.findById(id);
		if (optional.isPresent()) {
			courseRepository.delete(optional.get());
			return "Success!";
		}
		return "Failed!";
	}
	
	public List<Course> postAll(List<Course> list) {
		return courseRepository.saveAll(list);
	}
}
