package com.example.ToDoList.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.entities.concretes.ListElement;

public interface ListElementDao extends JpaRepository<ListElement, Integer> {

}
