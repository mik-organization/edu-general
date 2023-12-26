package com.example.demo.app.survey;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SurveyForm{
	
	public SurveyForm() {}

    public SurveyForm(int age, int satisfaction, String comment) {
		this.age = age;
		this.satisfaction = satisfaction;
		this.comment = comment;
	}

	@Min(0)
	@Max(150)
    private int age;

    @Min(1)
    @Max(5)
    private int satisfaction;

    @NotNull(message = "コメントを入力してください。")
    @Size(min = 1,max = 200, message = "1字以上200字以内で入力してください。")
    private String comment;


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
