package com.spring.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.entity.Applicant;
import com.spring.main.repository.ApplicantRepository;

@Service
public class ApplicantService {

	@Autowired
	ApplicantRepository applicantRepository;
	
	public Applicant post(Applicant applicant) {
		if (!applicant.equals(null)) {
			return applicantRepository.save(applicant);
		}
		return null;
	}
	
	public List<Applicant> getAll() {
		return applicantRepository.findAll();
	}
	
	public Applicant getById(int id) {
		Optional<Applicant> optional = applicantRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}	
		return null;
	}
	
	public Applicant update(Applicant applicant) {
//		Optional<Course> optional = courseRepository.findById(course.getCourseId());
//		if (optional.isPresent()) {
//			return optional.get();
//		}
		return applicantRepository.save(applicant);
	}
	
	public String delete(int id) {
		Optional<Applicant> optional = applicantRepository.findById(id);
		if (optional.isPresent()) {
			applicantRepository.delete(optional.get());
			return "Success!";
		}
		return "Failed!";
	}
	
	public List<Applicant> postAll(List<Applicant> list) {
		return applicantRepository.saveAll(list);
	}
}
