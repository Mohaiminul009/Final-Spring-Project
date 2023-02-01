package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.CourseFile;

@Repository
public interface CourseFileRepository extends JpaRepository<CourseFile, Integer>{

}
