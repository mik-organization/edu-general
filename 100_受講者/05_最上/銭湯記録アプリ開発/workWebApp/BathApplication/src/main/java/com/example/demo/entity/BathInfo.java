package com.example.demo.entity;

public class BathInfo {
	private int bathInfoId;
	private String bathName;
	private String address;
	private int openTime;
	private int closeTime;
	private int price;
	private String tel;
	private boolean roten;
	private boolean sauna;
	
	private Bath bath;
	
	public BathInfo() {
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

	public Bath getBath() {
		return bath;
	}

	public void setBath(Bath bath) {
		this.bath = bath;
	}


	
	
}
