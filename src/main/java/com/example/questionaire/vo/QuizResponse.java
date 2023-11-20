package com.example.questionaire.vo;

import com.example.questionaire.constants.RtnCode;
import com.example.questionaire.entity.MainTable;
import com.example.questionaire.entity.Questions;

public class QuizResponse {
	
	private QuizVo quizVo;
	
	public QuizResponse(QuizVo quizVo, RtnCode rtnCode) {
		super();
		this.quizVo = quizVo;
		this.rtnCode = rtnCode;
	}
	

	public QuizVo getQuizVo() {
		return quizVo;
	}

	public void setQuizVo(QuizVo quizVo) {
		this.quizVo = quizVo;
	}

	private RtnCode rtnCode;

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public QuizResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public QuizResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
