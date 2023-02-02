package com.spring.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "course_file")
public class CourseFile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int course_file_id;
	
	@Column(name = "course_pic")
	private String coursePic;
	
	@Column(name = "course_pdf")
	private String coursePdf;
	
	@Column(name = "course_video")
	private String courseVideo;
	
	@Column(name = "course_id")
	private int courseId;
	
	

//	public CourseFile(int course_file_id, String coursePic, String coursePdf, String courseVideo, int courseId) {
//		super();
//		this.course_file_id = course_file_id;
//		this.coursePic = coursePic;
//		this.coursePdf = coursePdf;
//		this.courseVideo = courseVideo;
//		this.courseId = courseId;
//	}

	public int getCourse_file_id() {
		return course_file_id;
	}

	public void setCourse_file_id(int course_file_id) {
		this.course_file_id = course_file_id;
	}

	public String getCoursePic() {
		return coursePic;
	}

	public void setCoursePic(String coursePic) {
		this.coursePic = coursePic;
	}

	public String getCoursePdf() {
		return coursePdf;
	}

	public void setCoursePdf(String coursePdf) {
		this.coursePdf = coursePdf;
	}

	public String getCourseVideo() {
		return courseVideo;
	}

	public void setCourseVideo(String courseVideo) {
		this.courseVideo = courseVideo;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	
}
