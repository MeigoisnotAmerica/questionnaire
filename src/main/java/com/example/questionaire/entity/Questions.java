package com.example.questionaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Questions")
@IdClass(value=Questions.class)
public class Questions {
	
	@Id
	@Column(name="questions_id")
	private int questionsId;
	
	@Column(name="main_table_id")
	private int mainTableId;
	
	@Column(name="main_table_title")
	private String mainTableTitle;
	
	@Column(name="option_type")
	private String optionType;
	
	@Column(name="is_necessary")
	private boolean necessary;
	
	@Column(name="questions_option")
	private String questionsOption;

	public int getQuestionsId() {
		return questionsId;
	}

	public int getMainTableId() {
		return mainTableId;
	}

	public void setMainTableId(int mainTableId) {
		this.mainTableId = mainTableId;
	}

	public String getMainTableTitle() {
		return mainTableTitle;
	}

	public void setMainTableTitle(String mainTableTitle) {
		this.mainTableTitle = mainTableTitle;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public boolean isNecessary() {
		return necessary;
	}

	public void setNecessary(boolean necessary) {
		this.necessary = necessary;
	}

	public String getOption() {
		return questionsOption;
	}

	public void setOption(String option) {
		this.questionsOption = option;
	}

	public void setQuestionsId(int questionsId) {
		this.questionsId = questionsId;
	}

	public Questions(int questionsId, int mainTableId, String mainTableTitle, String optionType, boolean necessary,
			String option) {
		super();
		this.questionsId = questionsId;
		this.mainTableId = mainTableId;
		this.mainTableTitle = mainTableTitle;
		this.optionType = optionType;
		this.necessary = necessary;
		this.questionsOption = option;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
