package com.example.ToDoList.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.entities.concretes.DailyList;


public interface DailyListDao extends JpaRepository<DailyList, Integer> {

}
