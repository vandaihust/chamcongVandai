package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.reponsitory.StatusDayRepository;
import com.vandai.mobi.services.impl.StatusDayServiceImpl;

@Service
public class StatusDayService implements StatusDayServiceImpl{

	@Autowired
	StatusDayRepository statusDayRepository;
	@Override
	public StatusDay addStatusDay(StatusDay statusDay) {
		statusDayRepository.save(statusDay);
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
