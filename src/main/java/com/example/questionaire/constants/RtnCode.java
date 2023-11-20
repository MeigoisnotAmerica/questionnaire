package com.example.questionaire.constants;

public enum RtnCode {
	SUCCESSFUL(200, "OK!"),//
	MAIN_TABLE_ID_PARAM_ERROR(400, "Main table id parameter error!!"),//
	MAIN_TABLE_PARAM_ERROR(400, "Main table parameter error!!"),//
	QUESTIONS_PARAM_ERROR(400, "Questions parameter error!!"),//
	MAIN_TABLE_ID_NOT_FOUND(404, "Main table id not found!!"),//
	UPDATE_ERROR(400, "Update error!!"),//
	;

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
