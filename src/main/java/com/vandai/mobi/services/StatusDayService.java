package com.vandai.mobi.services;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Shirt;
import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;
import com.vandai.mobi.reponsitory.ShirtRepository;
import com.vandai.mobi.reponsitory.StatusDayRepository;
import com.vandai.mobi.reponsitory.TimeKeepingRepository;
import com.vandai.mobi.services.impl.StatusDayServiceImpl;

@Service
public class StatusDayService implements StatusDayServiceImpl{

	@Autowired
	StatusDayRepository statusDayRepository;
	@Autowired
	TimeKeepingRepository timeKeepingRepository;
	@Autowired
	ShirtRepository shirtRepository;
	@Override
	public StatusDay addStatusDay() {
		StatusDay statusDay = new StatusDay();
		Calendar c = Calendar.getInstance();		
		Date date = new Date(c.getTime().getTime());
		System.out.println(c.getTime().getHours());
		Time time = new Time(c.getTime().getHours(), c.getTime().getMinutes(), c.getTime().getSeconds());
		System.out.println(time);
		
		statusDay.setInAt(time);
		Shirt shirt = shirtRepository.findById(1).get();
		if(date.getTime() < shirt.getEnd().getTime() && date.getTime() > shirt.getStart().getTime()) {
			statusDay.setInStatus(0);
		}
		statusDay.setStatus(true);
		TimeKeeping timeKeeping = new TimeKeeping();
		timeKeeping.setDate(date);
		timeKeeping.addStatusDay(statusDay);
		timeKeepingRepository.save(timeKeeping);
		return statusDay;
	}

	@Override
	public List<StatusDay> getAllStatusDay() {
		List<StatusDay> statusDays = statusDayRepository.findAll();
		return statusDays;
	}

	@Override
	public StatusDay updateStatusDay(StatusDay statusDay, int id) {
		statusDay.setId(id);
		statusDayRepository.save(statusDay);
		return statusDay;
	}

	@Override
	public String deleteStatusDay(int id) {
		statusDayRepository.deleteById(id);;
		return "Delete Success";
	}

	@Override
	public StatusDay getStatusDayById(int id) {		
		return statusDayRepository.findById(id).get();
	}

	@Override
	public List<StatusDay> fakeDataStatusDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatusDay getByInStatus(int inStatus) {
		return statusDayRepository.findByInStatus(inStatus);
	}

	@Override
	public StatusDay getByOutStatus(int outStatus) {
		return statusDayRepository.findByOutStatus(outStatus);
	}

	@Override
	public StatusDay getByStatus(int status) {
		return statusDayRepository.findByStatus(status);
	}

	@Override
	public StatusDay getByInAt(Date inAt) {
		return statusDayRepository.findByInAt(inAt);
	}

	@Override
	public StatusDay getByOutAt(Date outAt) {
		return statusDayRepository.findByOutAt(outAt);
	}

}
