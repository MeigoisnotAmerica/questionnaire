package com.example.questionaire.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.questionaire.entity.MainTable;
import com.example.questionaire.entity.Questions;

public class QuizVo {
	private MainTable mainTable = new MainTable();
	private List<Questions> questionsList = new ArrayList<>();
	public MainTable getMainTable() {
		return mainTable;
	}
	public void setMainTable(MainTable mainTable) {
		this.mainTable = mainTable;
	}
	public List<Questions> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
	public QuizVo(MainTable mainTable, List<Questions> questionsList) {
		super();
		this.mainTable = mainTable;
		this.questionsList = questionsList;
	}
	public QuizVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
