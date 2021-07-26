package com.example.ToDoList.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.business.abstracts.ListElementService;
import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.core.results.SuccessResult;
import com.example.ToDoList.dataAccess.DailyListDao;
import com.example.ToDoList.dataAccess.ListElementDao;
import com.example.ToDoList.entities.concretes.DailyList;
import com.example.ToDoList.entities.concretes.ListElement;

@Service
public class ListElementManager implements ListElementService {

	private ListElementDao listElementDao;
	private DailyListDao dailyListDao;
	@Autowired
	public ListElementManager(ListElementDao listElementDao , DailyListDao dailyListDao) {
		super();
		this.listElementDao = listElementDao;
		this.dailyListDao = dailyListDao;
	}

	@Override
	public SuccessResult add(ListElement listElement) {
		this.listElementDao.save(listElement);
		return new  SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result delete(int listElementId) {
		this.listElementDao.delete(this.listElementDao.getById(listElementId));
		return new SuccessResult("Silme Başarılı");
	}

	@Override
	public Result complete(int ListElementId, int DailyListId) {
		ListElement listElement = listElementDao.getById(ListElementId);
		listElement.setComplete(false);
		DailyList dailyList = dailyListDao.getById(DailyListId);
		dailyList.setClear(true);
		
		this.listElementDao.save(listElement);
		this.dailyListDao.save(dailyList);
		
		return new SuccessResult("Tamamlandı");
	}

}
