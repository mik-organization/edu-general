package com.example.demo.entity;

import java.sql.Date;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class BathIntegrationEntitiy {
	private int bathIntegrationEntitiyId;
	private int bathInfoId;
	private String bathName;
	private String address;
	private int openTime;
	private int closeTime;
	private int price;
	private String tel;
	private boolean roten;
	private boolean sauna;
	private int bathId;
	private int genreId;
	private int areaId;
	private String comments;
	private int reviewId;
	private double reviewValue;
	private double reviewAverage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recordDate;
	
	private Bath bath;
	private Comment comment;
	
	public BathIntegrationEntitiy() {
	}

	public int getBathIntegrationEntitiyId() {
		return bathIntegrationEntitiyId;
	}

	public void setBathIntegrationEntitiyId(int bathIntegrationEntitiyId) {
		this.bathIntegrationEntitiyId = bathIntegrationEntitiyId;
	}

	public int getBathInfoId() {
		return bathInfoId;
	}

	public void setBathInfoId(int bathInfoId) {
		this.bathInfoId = bathInfoId;
	}

	public String getBathName() {
		return bathName;
	}

	public void setBathName(String bathName) {
		this.bathName = bathName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOpenTime() {
		return openTime;
	}

	public void setOpenTime(int openTime) {
		this.openTime = openTime;
	}

	public int getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(int closeTime) {
		this.closeTime = closeTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public boolean isRoten() {
		return roten;
	}

	public void setRoten(boolean roten) {
		this.roten = roten;
	}

	public boolean isSauna() {
		return sauna;
	}

	public void setSauna(boolean sauna) {
		this.sauna = sauna;
	}

	public int getBathId() {
		return bathId;
	}

	public void setBathId(int bathId) {
		this.bathId = bathId;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String string) {
		this.comments = string;
	}
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	
	public double getReviewValue() {
		return reviewValue;
	}


	public void setReviewValue(double reviewValue) {
		this.reviewValue = reviewValue;
	}


	public double getReviewAverage() {
		return reviewAverage;
	}

	public void setReviewAverage(double reviewAverage) {
		this.reviewAverage = reviewAverage;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date date) {
		this.recordDate = date;
	}

	public Bath getBath() {
		return bath;
	}

	public void setBath(Bath bath) {
		this.bath = bath;
	}
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	
	
	
}
