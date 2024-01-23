package com.spring.edu_app2.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="m_user")	//DBのテーブル名とMapping
public class User {
	
	@Id	//主キー
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String password;
	private String email;
	//@CreatedDate
	//@LastModifiedDate
	//@CreationTimestamp
	@UpdateTimestamp
	private LocalDateTime updated;	//LocalDateTime

	public User() {
		}
	

	public User(String userName, String password, String email, LocalDateTime updated) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.updated = updated;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
	
}


