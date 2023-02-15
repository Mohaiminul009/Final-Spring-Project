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

import com.spring.main.entity.Course;
import com.spring.main.repository.CourseRepository;
import com.spring.main.service.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping("/post")
	public Course post(@RequestBody Course course) {
		return courseService.post(course);
	}
	
	@GetMapping("/get/{id}")
	public Course getById(@PathVariable int id) {
		return courseService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<Course> getAll() {
		return courseService.getAll();
	}
	
//	@PutMapping("/update")
//	public Course update(@RequestBody Course course) {
//		return courseService.update(course);
//	}
	
	@PutMapping("/update/{id}")
	Course update(@RequestBody Course course, @PathVariable int id) {
        return courseRepository.findById(id)
                .map(couRSE -> {
                	couRSE.setCourseName(course.getCourseName());
                	couRSE.setCourseUploadDate(course.getCourseUploadDate());
                	couRSE.setCourseDuration(course.getCourseDuration());
                	couRSE.setCourseArticle(course.getCourseArticle());
                	couRSE.setCourseResource(course.getCourseResource());
                	couRSE.setCourseAccess(course.getCourseAccess());
                	couRSE.setCourseDescription(course.getCourseDescription());
                	couRSE.setCourseCurriculum(course.getCourseCurriculum());
                	couRSE.setCoursePrice(course.getCoursePrice());
                	couRSE.setCourseDiscount(course.getCourseDiscount());
                    return courseRepository.save(couRSE);
                })
                .orElseGet(() -> {
                	course.setCourse_id(id);
                    return courseRepository.save(course);
                });
    }
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return courseService.delete(id);
	}
	
	@PostMapping("/postall")
	public List<Course> postAll(@RequestBody List<Course> list) {
		return courseService.postAll(list);
	}

	@GetMapping("/getbycat/{category}")
	List<Course> allByCategory(@PathVariable String category) {
		System.out.println(category);
		return courseRepository.gatAllByCategory(category);
	}
}
