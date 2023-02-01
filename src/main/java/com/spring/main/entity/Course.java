package com.spring.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int course_id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_upload_date")
	private String courseUploadDate;
	
	@Column(name = "course_duration")
	private String courseDuration;
	
	@Column(name = "course_article")
	private String courseArticle;
	
	@Column(name = "course_resource")
	private String courseResource;
	
	@Column(name = "course_access")
	private String courseAccess;
	
	@Column(name = "course_description")
	private String courseDescription;
	
	@Column(name = "course_curriculum")
	private String courseCurriculum;
	
	@Column(name = "course_cat_id")
	private int courseCatId;
	
	@Column(name = "course_price")
	private int coursePrice;
	
	@Column(name = "course_discount")
	private int courseDiscount;
	
	@Column(name = "instructor_id")
	private int instructorId;

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseUploadDate() {
		return courseUploadDate;
	}

	public void setCourseUploadDate(String courseUploadDate) {
		this.courseUploadDate = courseUploadDate;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseArticle() {
		return courseArticle;
	}

	public void setCourseArticle(String courseArticle) {
		this.courseArticle = courseArticle;
	}

	public String getCourseResource() {
		return courseResource;
	}

	public void setCourseResource(String courseResource) {
		this.courseResource = courseResource;
	}

	public String getCourseAccess() {
		return courseAccess;
	}

	public void setCourseAccess(String courseAccess) {
		this.courseAccess = courseAccess;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseCurriculum() {
		return courseCurriculum;
	}

	public void setCourseCurriculum(String courseCurriculum) {
		this.courseCurriculum = courseCurriculum;
	}

	public int getCourseCatId() {
		return courseCatId;
	}

	public void setCourseCatId(int courseCatId) {
		this.courseCatId = courseCatId;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public int getCourseDiscount() {
		return courseDiscount;
	}

	public void setCourseDiscount(int courseDiscount) {
		this.courseDiscount = courseDiscount;
	}
	
	
	
	
}
