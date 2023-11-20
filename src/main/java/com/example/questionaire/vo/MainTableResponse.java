package com.example.questionaire.vo;

import java.util.List;

import com.example.questionaire.constants.RtnCode;
import com.example.questionaire.entity.MainTable;

public class MainTableResponse {

	private List<MainTable> mainTableList;
	private RtnCode rtnCode;

	public List<MainTable> getMainTableList() {
		return mainTableList;
	}

	public void setMainTableList(List<MainTable> mainTableList) {
		this.mainTableList = mainTableList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public MainTableResponse(List<MainTable> mainTableList, RtnCode rtnCode) {
		super();
		this.mainTableList = mainTableList;
		this.rtnCode = rtnCode;
	}

	public MainTableResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
