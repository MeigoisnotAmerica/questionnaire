package com.example.questionaire.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionaire.entity.MainTable;

@Repository
public interface MainTableDao extends JpaRepository<MainTable, Integer>{

	public List<MainTable> findByIdIn(List<Integer> mainTableIdList);

	public List<MainTable> findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String title, LocalDate startDate, LocalDate endDate);
}
