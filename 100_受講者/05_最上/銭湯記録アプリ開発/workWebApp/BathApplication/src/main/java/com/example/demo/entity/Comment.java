package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
	private int commentId;
	private String comment;
	private int reviewId;
	private int bathInfoId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recordDate;
	
	public Comment() {
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getBathInfoId() {
		return bathInfoId;
	}

	public void setBathInfoId(int bathInfoId) {
		this.bathInfoId = bathInfoId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	
	
	
}
