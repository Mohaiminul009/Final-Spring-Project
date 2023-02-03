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

import com.spring.main.entity.Instructor;
import com.spring.main.repository.InstructorRepository;
import com.spring.main.service.InstructorService;

@RestController
@RequestMapping("/instructor")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class InstructorController {

	@Autowired
	InstructorService instructorService;
	
	@Autowired
	InstructorRepository instructorRepository;
	
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
	
//	@PutMapping("/update")
//	public Instructor update(@RequestBody Instructor instructor) {
//		return instructorService.update(instructor);
//	}
	
	@PutMapping("/update/{id}")
	Instructor update(@RequestBody Instructor instructor, @PathVariable int id) {
        return instructorRepository.findById(id)
                .map(insTRUCTOR -> {
                	insTRUCTOR.setInstructorName(instructor.getInstructorName());
                	insTRUCTOR.setInstructorUsername(instructor.getInstructorUsername());
                	insTRUCTOR.setInstructorPassword(instructor.getInstructorPassword());
                	insTRUCTOR.setInstructorEmail(instructor.getInstructorEmail());
                	insTRUCTOR.setInstructorPhone(instructor.getInstructorPhone());
                	insTRUCTOR.setInstructorNid(instructor.getInstructorNid());
                	insTRUCTOR.setInstructorDesignation(instructor.getInstructorDesignation());
                	insTRUCTOR.setInstructorWorkplace(instructor.getInstructorWorkplace());
                	insTRUCTOR.setInstructorPic(instructor.getInstructorPic());
                    return instructorRepository.save(insTRUCTOR);
                })
                .orElseGet(() -> {
                	instructor.setInstructor_id(id);
                    return instructorRepository.save(instructor);
                });
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
