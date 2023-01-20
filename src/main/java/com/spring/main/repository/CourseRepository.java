package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
