package com.example.questionaire.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionaire.vo.MainTableResponse;
import com.example.questionaire.vo.QuizRequest;
import com.example.questionaire.vo.QuizResponse;

public interface QuizService {

	QuizResponse createQuestionnaire(QuizRequest request);

	QuizResponse editQuestionnaire(QuizRequest request);

	QuizResponse deleteQuestionnaire(List<Integer> mainTableIdList);

	QuizResponse deleteQuestions(int mainTableId, List<Integer> questionsIdList);

	QuizResponse searchQuestionnaire(String title, LocalDate startDate, LocalDate endDate);
	
	MainTableResponse searchQuestionnaireList(String title, LocalDate startDate, LocalDate endDate);

}
