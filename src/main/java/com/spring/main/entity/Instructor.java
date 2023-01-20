package com.spring.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "instructor")
@Data
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instructor_id;
	
	@Column(name = "instructor_name")
	private String instructorName;
	
	@Column(name = "instructor_username")
	private String instructorUsername;
	
	@Column(name = "instructor_password")
	private String instructorPassword;
	
	@Column(name = "instructor_email")
	private String instructorEmail;
	
	@Column(name = "instructor_phone")
	private String instructorPhone;
	
	@Column(name = "instructor_nid")
	private String instructorNid;
	
	@Column(name = "instructor_designation")
	private String instructorDesignation;
	
	@Column(name = "instructor_workplace")
	private String instructorWorkplace;
}
