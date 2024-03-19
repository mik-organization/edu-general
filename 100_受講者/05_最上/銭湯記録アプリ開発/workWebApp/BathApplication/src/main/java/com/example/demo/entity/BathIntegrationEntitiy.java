package com.example.demo.entity;

import java.util.List;

public class BathIntegrationEntitiy {
	private int bathIntegrationEntitiyId;
	private int bathInfoId;
	private String bathName;
	private String address;
	private int openTime;
	private int closeTime;
	private int price;
	private int tel;
	private boolean roten;
	private boolean sauna;
	private int bathId;
	private int genreId;
	private int areaId;
	private List<String> comments;
	
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
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

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> string) {
		this.comments = string;
	}

	public Comment getComment() {
		return comment;
	}

	
	public Bath getBath() {
		return bath;
	}

	public void setBath(Bath bath) {
		this.bath = bath;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
	
}
