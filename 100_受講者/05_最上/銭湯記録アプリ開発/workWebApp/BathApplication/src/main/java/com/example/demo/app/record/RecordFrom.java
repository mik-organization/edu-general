package com.example.demo.app.record;

//import jakarta.validation.constraints.NotNull;

public class RecordFrom {

	private String bathName;
	private String address;
	private int openTime;
	private int closeTime;
	private int price;
	private int tel;
	private boolean roten;
	private boolean sauna;
	
	
	public RecordFrom() {
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
	
	
}
