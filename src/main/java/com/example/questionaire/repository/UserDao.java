package com.example.questionaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionaire.entity.MainTable;
import com.example.questionaire.entity.Questions;
import com.example.questionaire.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, String>{
	

}
