package com.example.questionaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="main_table")
 public class MainTable{
	
	@Id
	@Column(name="main_table_id")
	private int mainTableId;
	
	@Column(name="questions_title")
	private String questionsTitle;
	
	@Column(name="description")
	private String description;

	@Column(name="is_published")
	private boolean published;
	
	@Column(name="start_date")
	private LocalDate startDate;

	@Column(name="end_date")
	private LocalDate endDate;

	public int getMainTableId() {
		return mainTableId;
	}

	public void setMainTableId(int mainTableId) {
		this.mainTableId = mainTableId;
	}

	public String getQuestionsTitle() {
		return questionsTitle;
	}

	public void setQuestionsTitle(String questionsTitle) {
		this.questionsTitle = questionsTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public MainTable(int mainTableId, String questionsTitle, String description, boolean published, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.mainTableId = mainTableId;
		this.questionsTitle = questionsTitle;
		this.description = description;
		this.published = published;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public MainTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}