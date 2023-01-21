package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.CoursePrice;

@Repository
public interface CoursePriceRepository extends JpaRepository<CoursePrice, Integer>{

}
