package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
