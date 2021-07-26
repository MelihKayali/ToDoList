package com.example.ToDoList.business.abstracts;

import java.util.List;

import com.example.ToDoList.core.results.DataResult;
import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.core.results.SuccessResult;
import com.example.ToDoList.entities.concretes.DailyList;

public interface DailyListService {
    DataResult<List<DailyList>> getAll();
    SuccessResult add(DailyList dailyList);
    Result delete(int dailyListId);
    
}
