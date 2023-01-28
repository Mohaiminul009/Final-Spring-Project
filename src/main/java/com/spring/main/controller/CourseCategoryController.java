package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.main.entity.CourseCategory;
import com.spring.main.repository.CourseCategoryRepository;
import com.spring.main.service.CourseCategoryService;

@RestController
@RequestMapping("/coursecat")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CourseCategoryController {

	@Autowired
	private CourseCategoryService courseCategoryService;
	private CourseCategoryRepository courseCategoryRepository;
	
	@PostMapping("/post")
	public CourseCategory post(@RequestBody CourseCategory courseCategory) {
		return courseCategoryService.post(courseCategory);
	}
	
	@GetMapping("/get/{id}")
	public CourseCategory getById(@PathVariable int id) {
		return courseCategoryService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<CourseCategory> getAll() {
		return courseCategoryService.getAll();
	}
	
//	@PutMapping("/update")
//	public CourseCategory update(@RequestBody CourseCategory courseCategory) {
//		return courseCategoryService.update(courseCategory);
//	}
	
	@PutMapping("/update/{id}")
	CourseCategory update(@RequestBody CourseCategory courseCategory, @PathVariable int id) {
        return courseCategoryRepository.findById(id)
                .map(courseCat -> {
                	courseCat.setCourseCatName(courseCategory.getCourseCatName());
                    return courseCategoryRepository.save(courseCategory);
                })
                .orElseGet(() -> {
                	courseCategory.setCourse_cat_id(id);
                    return courseCategoryRepository.save(courseCategory);
                });
    }
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return courseCategoryService.delete(id);
	}
	
	@PostMapping("/postall")
	public List<CourseCategory> postAll(@RequestBody List<CourseCategory> list) {
		return courseCategoryService.postAll(list);
	}
}
