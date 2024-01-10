package com.example.demo.app.survey;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SurveyForm {
	
	//@Size(min=0,max=150,message="must be less than or eqaul to 150")
	@Min(0)
	@Max(150)
	@NotNull
	private int age;
	
	//@Size(min=1,max=5,message="must be less than or eqaul to 5")
	@Min(1)
	@Max(5)
	@NotNull
	private int satisfaction;
	
	@Size(min=1,max=200,message="Please input 200characters")
	@NotNull
	private String comment;
	
	public SurveyForm() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
