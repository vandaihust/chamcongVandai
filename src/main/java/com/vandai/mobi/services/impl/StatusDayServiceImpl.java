package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;

public interface StatusDayServiceImpl {
	public StatusDay addStatusDay(StatusDay statusDay,int idTimeKeeping);
	public List<StatusDay> getAllStatusDay();
	public StatusDay updateStatusDay(StatusDay statusDay, int id);
	public String deleteStatusDay(int id);
	public StatusDay getStatusDayById(int id);
	public List<StatusDay> fakeDataStatusDay();
	public List<StatusDay> getByInStatus(int inStatus);
	public List<StatusDay> getByOutStatus(int outStatus);
	public List<StatusDay> getByStatus(int status);
	public List<StatusDay> getByInAt(Date inAt);
	public List<StatusDay> getByOutAt(Date outAt);
	
	public List<StatusDay> getStatusDayByTimeKeeping(int idTimeKeeping);
	public StatusDay checkIn(long id);
	public StatusDay checkOut(long id);
}
