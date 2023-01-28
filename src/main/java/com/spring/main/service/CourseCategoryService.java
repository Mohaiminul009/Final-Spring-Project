package com.spring.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.entity.CourseCategory;
import com.spring.main.repository.CourseCategoryRepository;

@Service
public class CourseCategoryService {

	@Autowired
	private CourseCategoryRepository courseCategoryRepository;
	
	public CourseCategory post(CourseCategory courseCategory) {
		if (!courseCategory.equals(null)) {
			return courseCategoryRepository.save(courseCategory);
		}
		return null;
	}
	
	public List<CourseCategory> getAll() {
		return courseCategoryRepository.findAll();
	}
	
	public CourseCategory getById(int id) {
		Optional<CourseCategory> optional = courseCategoryRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}	
		return null;
	}
	
//	public CourseCategory update(CourseCategory courseCategory) {
//		Optional<CourseCategory> optional = courseCategoryRepository.findById(courseCategory.getCourse_cat_id());
//		if (optional.isPresent()) {
//			return optional.get();
//		}
//		return courseCategoryRepository.save(courseCategory);
//	}
	
	public String delete(int id) {
		Optional<CourseCategory> optional = courseCategoryRepository.findById(id);
		if (optional.isPresent()) {
			courseCategoryRepository.delete(optional.get());
			return "Success!";
		}
		return "Failed!";
	}
	
	public List<CourseCategory> postAll(List<CourseCategory> list) {
		return courseCategoryRepository.saveAll(list);
	}
}
