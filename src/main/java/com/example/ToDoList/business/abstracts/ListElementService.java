package com.example.ToDoList.business.abstracts;

import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.core.results.SuccessResult;
import com.example.ToDoList.entities.concretes.ListElement;

public interface ListElementService {
	 SuccessResult add(ListElement listElement);
	 Result delete(int ListElementId);
	 Result complete(int ListElementId ,int DailyListId );
	 
}
