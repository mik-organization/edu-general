package com.example.demo.entity;

public class Bath {
	private int bathId;
	private int bathInfoId;
	private int genreId;
	private int areaId;
	private double reviewAverage;
	
	public Bath() {
	}

	public int getBathId() {
		return bathId;
	}

	public void setBathId(int bathId) {
		this.bathId = bathId;
	}

	public int getBathInfoId() {
		return bathInfoId;
	}

	public void setBathInfoId(int bathInfoId) {
		this.bathInfoId = bathInfoId;
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

	public double getReviewAverage() {
		return reviewAverage;
	}

	public void setReviewAverage(double reviewAverage) {
		this.reviewAverage = reviewAverage;
	}
	
}
