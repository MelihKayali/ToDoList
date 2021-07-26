package com.example.ToDoList.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.business.abstracts.DailyListService;
import com.example.ToDoList.core.results.DataResult;
import com.example.ToDoList.core.results.Result;
import com.example.ToDoList.core.results.SuccessDataResult;
import com.example.ToDoList.core.results.SuccessResult;
import com.example.ToDoList.dataAccess.DailyListDao;
import com.example.ToDoList.entities.concretes.DailyList;

@Service
public class DailyListManager implements DailyListService {

	private DailyListDao dailyListDao;
	
	@Autowired
	public DailyListManager(DailyListDao dailyListDao) {
		super();
		this.dailyListDao = dailyListDao;
	}

	@Override
	public DataResult<List<DailyList>> getAll() {
		return new SuccessDataResult<List<DailyList>>(this.dailyListDao.findAll());
	}

	@Override
	public SuccessResult add(DailyList dailyList) {
		this.dailyListDao.save(dailyList);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result delete(int dailyListId) {
		this.dailyListDao.delete(this.dailyListDao.getById(dailyListId));
		return new SuccessResult("Silme Başarılı");
	}

}
