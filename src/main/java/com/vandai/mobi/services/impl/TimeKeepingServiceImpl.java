package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.TimeKeeping;

public interface TimeKeepingServiceImpl {
	public TimeKeeping addTimeKeeping(TimeKeeping timeKeeping, long idEmployee);
	public List<TimeKeeping> getAllTimeKeeping();
	public TimeKeeping updateTimeKeeping(TimeKeeping timeKeeping, int id);
	public String deleteTimeKeeping(int id);
	public TimeKeeping getTimeKeepingById(int id);
	public List<TimeKeeping> getTimeKeepingStatusOfDay(int statusOfDay);
	public List<TimeKeeping> getTimeKeepingByHour(long hour);
	public List<TimeKeeping> getTimeKeepingDate(Date date);
	public List<TimeKeeping> getTimeKeepingEmployee(long id);
	public List<TimeKeeping> fakeDataTimeKeeping();
}
