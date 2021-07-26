package com.example.ToDoList.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoList.business.abstracts.ListElementService;
import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.entities.concretes.ListElement;

@RestController
@RequestMapping("/api/listelements")
public class ListElementController {

	private ListElementService listElementService;
	
	@Autowired
	public ListElementController(ListElementService listElementService) {
		super();
		this.listElementService = listElementService;
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ListElement listElement) {
		return this.listElementService.add(listElement);
	}
	
	@DeleteMapping("/delete/{listElementId}")
	public Result delete(@Valid @PathVariable int listElementId) {
		return this.listElementService.delete(listElementId);
	}
	
	@PutMapping("/complete")
	public Result complete(int ListElementId ,int DailyListId) {
		return this.listElementService.complete(ListElementId, DailyListId);
	}
}
