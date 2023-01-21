package com.spring.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course_prices")
@Data
public class CoursePrice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int course_price_id;
	
	@Column(name = "course_price")
	private int coursePrice;
	
	@Column(name = "course_id")
	private int courseId;
	
	@Column(name = "course_price_vat")
	private int coursePriceVat;
	
	@Column(name = "course_price_discount")
	private int coursePriceDiscount;

	public int getCourse_price_id() {
		return course_price_id;
	}

	public void setCourse_price_id(int course_price_id) {
		this.course_price_id = course_price_id;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getCoursePriceVat() {
		return coursePriceVat;
	}

	public void setCoursePriceVat(int coursePriceVat) {
		this.coursePriceVat = coursePriceVat;
	}

	public int getCoursePriceDiscount() {
		return coursePriceDiscount;
	}

	public void setCoursePriceDiscount(int coursePriceDiscount) {
		this.coursePriceDiscount = coursePriceDiscount;
	}
	
	
}
