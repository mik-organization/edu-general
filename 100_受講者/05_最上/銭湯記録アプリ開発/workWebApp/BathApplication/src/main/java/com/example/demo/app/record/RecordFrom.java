package com.example.demo.app.record;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//import jakarta.validation.constraints.NotNull;

public class RecordFrom {

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
	private Date recordDate;
	
	private List<String>commentList;
	
	
	public RecordFrom() {
		this.bathIntegrationEntitiyId = bathIntegrationEntitiyId;
		this.bathInfoId = bathInfoId;
		this.bathName = bathName;
		this.address = address;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.price = price;
		this.tel = tel;
		this.roten = roten;
		this.sauna = sauna;
		this.bathId = bathId;
		this.genreId = genreId;
		this.areaId = areaId;
		this.comments = comments;
		this.reviewId = reviewId;
		this.recordDate = recordDate;
		this.commentList = commentList;
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
	public boolean getIsRoten() {
		return roten;
	}
	public void setRoten(boolean roten) {
		this.roten = roten;
	}
	public boolean getIsSauna() {
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
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public List<String> getCommentList() {
		return commentList;
	}


	public void setCommentList(List<String> commentList) {
		this.commentList = commentList;
	}
	
	
	
}
