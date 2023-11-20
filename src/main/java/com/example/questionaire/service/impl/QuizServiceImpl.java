package com.example.questionaire.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionaire.constants.RtnCode;
import com.example.questionaire.entity.MainTable;
import com.example.questionaire.entity.Questions;
import com.example.questionaire.repository.MainTableDao;
import com.example.questionaire.repository.QuestionsDao;
import com.example.questionaire.service.ifs.QuizService;
import com.example.questionaire.vo.MainTableResponse;
import com.example.questionaire.vo.QuizRequest;
import com.example.questionaire.vo.QuizResponse;

@Service // 標記為 Spring 服務

public class QuizServiceImpl implements QuizService {

	@Autowired // 自動注入 MainTableDao
	private MainTableDao mainTableDao;

	@Autowired // 自動注入 QuestionsDao
	private QuestionsDao questionsDao;

	// 檢查參數是否有效的方法
	private QuizResponse checkParameter(QuizRequest request) {

		MainTable mainTable = request.getMainTable();
		// 檢查 MainTable 參數
		if (!StringUtils.hasText(mainTable.getQuestionsTitle()) || !StringUtils.hasText(mainTable.getDescription())
				|| mainTable.getStartDate() == null || mainTable.getEndDate() == null
				|| mainTable.getStartDate().isAfter(mainTable.getEndDate())) {
			return new QuizResponse(RtnCode.MAIN_TABLE_PARAM_ERROR); // 如果 MainTable 參數有誤，返回錯誤響應
		}

		// 檢查 Questions 列表中的每一個元素
		List<Questions> questionsList = request.getQuestionsList();
		for (Questions question : questionsList) {
			if (question.getMainTableId() <= 0 || !StringUtils.hasText(question.getMainTableTitle())
					|| !StringUtils.hasText(question.getOptionType()) || !StringUtils.hasText(question.getOption())) {
				return new QuizResponse(RtnCode.QUESTIONS_PARAM_ERROR); // 如果 Questions 參數有誤，返回錯誤響應
			}
		}
		return null; // 如果所有參數均正確，則返回 null
	}

	@Override
	@Transactional // 標記為事務性操作
	public QuizResponse createQuestionnaire(QuizRequest request) {
		QuizResponse checkResult = checkParameter(request); // 檢查輸入參數是否正確
		if (checkResult != null) {
			return checkResult; // 如果有錯誤，返回錯誤響應
		}

		int mainTableId = mainTableDao.save(request.getMainTable()).getMainTableId(); // 儲存 MainTable
		List<Questions> questionsList = request.getQuestionsList();
		if (questionsList.isEmpty()) {
			return new QuizResponse(RtnCode.SUCCESSFUL); // 返回成功的響應
		}
		for (Questions question : questionsList) {
			question.setMainTableId(mainTableId); // 為每個問題設置 MainTable 的 ID
		}
		questionsDao.saveAll(questionsList); // 儲存所有問題
		return new QuizResponse(RtnCode.SUCCESSFUL); // 返回成功的響應
	}

	// 檢查參數是否有效的方法
	private QuizResponse checkMainTableId(QuizRequest request) {

		if (request.getMainTable().getMainTableId() <= 0) {
			return new QuizResponse(RtnCode.MAIN_TABLE_ID_PARAM_ERROR);
		}

		List<Questions> questionsList = request.getQuestionsList();
		for (Questions questions : questionsList) {
			if (questions.getMainTableId() != request.getMainTable().getMainTableId()) {
				return new QuizResponse(RtnCode.MAIN_TABLE_ID_PARAM_ERROR);
			}
		}
		return null; // 如果所有參數均正確，則返回 null
	}

	@Override
	@Transactional
	public QuizResponse editQuestionnaire(QuizRequest request) {
		QuizResponse checkResultParameter = checkParameter(request);
		QuizResponse checkResultId = checkMainTableId(request);

		if (checkResultParameter != null) {
			return checkResultParameter;
		} else if (checkResultId != null) {
			return checkResultId;
		}

		Optional<MainTable> mainTableOptional = mainTableDao.findById(request.getMainTable().getMainTableId());
		if (mainTableOptional.isEmpty()) {
			return new QuizResponse(RtnCode.MAIN_TABLE_ID_NOT_FOUND);
		}

		MainTable mainTable = mainTableOptional.get();
		if (!mainTable.isPublished()
				|| (mainTable.isPublished() && LocalDate.now().isBefore(mainTable.getStartDate()))) {
			mainTableDao.save(request.getMainTable());
			questionsDao.saveAll(request.getQuestionsList());
			return new QuizResponse(RtnCode.SUCCESSFUL);
		}

		return new QuizResponse(RtnCode.UPDATE_ERROR);
	}

	@Override
	public QuizResponse deleteQuestionnaire(List<Integer> mainTableIdList) {
		List<MainTable> mainTableList = mainTableDao.findByIdIn(mainTableIdList);
		List<Integer> questionsIdList = new ArrayList<>();
		for (MainTable mainTable : mainTableList) {
			if (!mainTable.isPublished()
					|| (mainTable.isPublished() && LocalDate.now().isBefore(mainTable.getStartDate()))) {
				questionsIdList.add(mainTable.getMainTableId());
			}
		}
		if (!questionsIdList.isEmpty()) {
			mainTableDao.deleteAllById(mainTableIdList);
			questionsDao.deleteAllByMainTableId(questionsIdList);
		}
		return new QuizResponse(RtnCode.SUCCESSFUL);
	}

	@Override
	public QuizResponse deleteQuestions(int mainTableId, List<Integer> questionsIdList) {
		Optional<MainTable> mainTableOptional = mainTableDao.findById(mainTableId);
		if (mainTableOptional.isEmpty()) {
			return new QuizResponse(RtnCode.SUCCESSFUL);
		}
		MainTable mainTable = mainTableOptional.get();
		if (!mainTable.isPublished()
				|| mainTable.isPublished() && !LocalDate.now().isBefore(mainTable.getStartDate())) {
			questionsDao.deleteAllByMainTableIdIn(questionsIdList);
		}
		return new QuizResponse(RtnCode.SUCCESSFUL);
	}

	@Override
	public QuizResponse searchQuestionnaire(String title, LocalDate startDate, LocalDate endDate) {
	    title = StringUtils.hasText(title) ? title : "";
	    startDate = startDate != null ? startDate : LocalDate.of(1970, 1, 1);
	    endDate = endDate != null ? endDate : LocalDate.of(2040, 1, 1);
	    List<MainTable> mainTableList = mainTableDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title, startDate, endDate);
	    	
		return null;
	}
	
	@Override
	public MainTableResponse searchQuestionnaireList(String title, LocalDate startDate, LocalDate endDate) {
	    title = StringUtils.hasText(title) ? title : "";
	    startDate = startDate != null ? startDate : LocalDate.of(1970, 1, 1);
	    endDate = endDate != null ? endDate : LocalDate.of(2040, 1, 1);
	    List<MainTable> mainTableList = mainTableDao.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title, startDate, endDate);

	    return new MainTableResponse(mainTableList, RtnCode.SUCCESSFUL);
	}


} // 類別結束
