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

import com.spring.main.entity.Instructor;
import com.spring.main.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/post")
	public Instructor post(@RequestBody Instructor instructor) {
		return instructorService.post(instructor);
	}
	
	@GetMapping("/get/{id}")
	public Instructor getById(@PathVariable int id) {
		return instructorService.getById(id);
	}
	
	@GetMapping("/getall")
	public List<Instructor> getAll() {
		return instructorService.getAll();
	}
	
	@PutMapping("/update")
	public Instructor update(@RequestBody Instructor instructor) {
		return instructorService.update(instructor);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return instructorService.delete(id);
	}
	
	@PostMapping("/postall")
	public List<Instructor> postAll(@RequestBody List<Instructor> list) {
		return instructorService.postAll(list);
	}
}
