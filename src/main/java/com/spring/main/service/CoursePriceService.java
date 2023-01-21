package com.spring.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.entity.CoursePrice;
import com.spring.main.repository.CoursePriceRepository;

@Service
public class CoursePriceService {

	@Autowired
	private CoursePriceRepository coursePriceRepository;
	
	public CoursePrice post(CoursePrice coursePrice) {
		if (!coursePrice.equals(null)) {
			return coursePriceRepository.save(coursePrice);
		}
		return null;
	}
	
	public List<CoursePrice> getAll() {
		return coursePriceRepository.findAll();
	}
	
	public CoursePrice getById(int id) {
		Optional<CoursePrice> optional = coursePriceRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}	
		return null;
	}
	
	public CoursePrice update(CoursePrice coursePrice) {
//		Optional<Course> optional = courseRepository.findById(course.getCourseId());
//		if (optional.isPresent()) {
//			return optional.get();
//		}
		return coursePriceRepository.save(coursePrice);
	}
	
	public String delete(int id) {
		Optional<CoursePrice> optional = coursePriceRepository.findById(id);
		if (optional.isPresent()) {
			coursePriceRepository.delete(optional.get());
			return "Success!";
		}
		return "Failed!";
	}
	
	public List<CoursePrice> postAll(List<CoursePrice> list) {
		return coursePriceRepository.saveAll(list);
	}
}
