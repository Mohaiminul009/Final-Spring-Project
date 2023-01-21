package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.main.entity.CoursePrice;
import com.spring.main.service.CoursePriceService;

@RestController
@RequestMapping("/courseprice")
public class CoursePriceController {

	@Autowired
	private CoursePriceService coursePriceService;
	
	@PostMapping("/post")
	public CoursePrice post(@RequestBody CoursePrice coursePrice) {
		return coursePriceService.post(coursePrice);
	}
	
	@GetMapping("/get/{id}")
	public CoursePrice getById(@PathVariable int id) {
		return coursePriceService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<CoursePrice> getAll() {
		return coursePriceService.getAll();
	}
	
	@PutMapping("/update")
	public CoursePrice update(@RequestBody CoursePrice coursePrice) {
		return coursePriceService.update(coursePrice);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return coursePriceService.delete(id);
	}
	
	@PostMapping("/postall")
	public List<CoursePrice> postAll(@RequestBody List<CoursePrice> list) {
		return coursePriceService.postAll(list);
	}
}
