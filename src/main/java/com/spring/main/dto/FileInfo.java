package com.spring.main.dto;

public class FileInfo {

	private String pic;
	private String pdf;
	private String video;
	
	public FileInfo(String pic, String pdf, String video) {
	    this.pic = pic;
	    this.pdf = pdf;
	    this.video = video;
	  }

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	
}
