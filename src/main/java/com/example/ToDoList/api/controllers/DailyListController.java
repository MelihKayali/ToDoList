package com.example.ToDoList.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoList.business.abstracts.DailyListService;
import com.example.ToDoList.core.results.DataResult;
import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.entities.concretes.DailyList;

@RestController
@RequestMapping("/api/dailylists")
public class DailyListController {
	
	private DailyListService dailyListService;
	
	@Autowired
	public DailyListController(DailyListService dailyListService) {
		super();
		this.dailyListService = dailyListService;
	}
	
	@GetMapping("/gelAll")
	public DataResult<List<DailyList>> getAll(){
		return this.dailyListService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody DailyList dailyList) {
		return this.dailyListService.add(dailyList);
	}
	
	@DeleteMapping("/delete/{dailyListId}")
	public Result delete(@Valid @PathVariable int dailyListId) {
		return this.dailyListService.delete(dailyListId);
	}
}
