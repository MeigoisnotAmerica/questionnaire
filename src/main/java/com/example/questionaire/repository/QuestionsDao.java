package com.example.questionaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionaire.entity.MainTable;
import com.example.questionaire.entity.Questions;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, String> {

	void deleteAllByMainTableId(List<Integer> questionsIdList);

	void deleteAllByMainTableIdIn(List<Integer> questionsIdList);
}

