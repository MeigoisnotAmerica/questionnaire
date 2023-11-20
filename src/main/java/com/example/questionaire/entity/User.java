package com.example.questionaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {

	@Column(name="main_table_id")
	private int mainTableId;
	
	@Id
	@Column(name="questions_id")
	private int questionsId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="age")
	private int age;
	
	@Column(name="answer")
	private String answer;

	public int getQuestionsId() {
		return questionsId;
	}

	public int getMainTableId() {
		return mainTableId;
	}

	public void setMainTableId(int mainTableId) {
		this.mainTableId = mainTableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setQuestionsId(int questionsId) {
		this.questionsId = questionsId;
	}

	public User(int mainTableId, int questionsId, String name, String phoneNumber, String email, int age,
			String answer) {
		super();
		this.mainTableId = mainTableId;
		this.questionsId = questionsId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.answer = answer;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
