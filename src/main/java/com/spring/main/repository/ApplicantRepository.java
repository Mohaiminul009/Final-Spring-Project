package com.spring.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.main.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

	@Query(value = "SELECT COUNT(applicant_id) AS total FROM applicant_form ", nativeQuery = true)
	Integer countAll();
}
