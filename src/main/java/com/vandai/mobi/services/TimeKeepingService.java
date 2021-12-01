package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.TimeKeeping;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.TimeKeepingRepository;
import com.vandai.mobi.services.impl.TimeKeepingServiceImpl;
@Service
public class TimeKeepingService implements TimeKeepingServiceImpl{
	@Autowired
	TimeKeepingRepository timeKeepingRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Override
	public TimeKeeping addTimeKeeping(TimeKeeping timeKeeping) {
		timeKeepingRepository.save(timeKeeping);
		return null;
	}

	@Override
	public List<TimeKeeping> getAllTimeKeeping() {
		List<TimeKeeping> keepings = timeKeepingRepository.findAll();
		return keepings;
	}

	@Override
	public TimeKeeping updateTimeKeeping(TimeKeeping timeKeeping, int id) {
		timeKeeping.setId(id);
		timeKeepingRepository.save(timeKeeping);
		return timeKeeping;
	}

	@Override
	public String deleteTimeKeeping(int id) {
		timeKeepingRepository.deleteById(id);
		return "Delete Successfully";
	}

	@Override
	public TimeKeeping getTimeKeepingById(int id) {
		TimeKeeping timeKeeping = timeKeepingRepository.findById(id).get();
		return timeKeeping;
	}

	@Override
	public List<TimeKeeping> getTimeKeepingStatusOfDay(int statusOfDay) {
		List<TimeKeeping> times = timeKeepingRepository.findByStatusOfDay(statusOfDay);
		return times;
	}

	@Override
	public List<TimeKeeping> getTimeKeepingByHour(long hour) {
		List<TimeKeeping> times = timeKeepingRepository.findByHour(hour);
		return times;
	}

	@Override
	public List<TimeKeeping> getTimeKeepingDate(Date date) {
		List<TimeKeeping> times = timeKeepingRepository.findByDate(date);
		return times;
	}

	@Override
	public List<TimeKeeping> fakeDataTimeKeeping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeKeeping> getTimeKeepingEmployee(long id) {
		Employee e = employeeRepository.findById(id).get();
		List<TimeKeeping> timeKeepings = timeKeepingRepository.findByEmployee(e);
		return timeKeepings;
	}

}
