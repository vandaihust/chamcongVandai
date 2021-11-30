package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.StatusDay;

public interface StatusDayServiceImpl {
	public StatusDay addStatusDay(long id);
	public List<StatusDay> getAllStatusDay();
	public StatusDay updateStatusDay(StatusDay statusDay, int id);
	public String deleteStatusDay(int id);
	public StatusDay getStatusDayById(int id);
	public List<StatusDay> fakeDataStatusDay();
	public StatusDay getByInStatus(int inStatus);
	public StatusDay getByOutStatus(int outStatus);
	public StatusDay getByStatus(int status);
	public StatusDay getByInAt(Date inAt);
	public StatusDay getByOutAt(Date outAt);
	public StatusDay checkIn(long id);
	public StatusDay checkOut(long id);
}
