package com.vandai.mobi.services;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Shirt;
import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;
import com.vandai.mobi.reponsitory.EmployeeRepository;
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
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	TimeKeepingService timeKeepingService;
	@Override
	public StatusDay addStatusDay(StatusDay statusDay,int idTimeKeeping) {
		statusDay.setTimeKeeping(timeKeepingRepository.findById(idTimeKeeping).get());
		statusDayRepository.save(statusDay);
		return statusDay;
	}
//	inAt:0 : muộn
//	     1: đúng giờ
//
//  status: true: đang làm việc
//	false: vắng
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
		return "Delete Successfully";
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
	public List<StatusDay> getByInStatus(int inStatus) {
		return statusDayRepository.findByInStatus(inStatus);
	}

	@Override
	public List<StatusDay> getByOutStatus(int outStatus) {
		return statusDayRepository.findByOutStatus(outStatus);
	}

	@Override
	public List<StatusDay> getByStatus(int status) {
		return statusDayRepository.findByStatus(status);
	}

	@Override
	public List<StatusDay> getByInAt(Time inAt) {
		return statusDayRepository.findByInAt(inAt);
	}

	@Override
	public List<StatusDay> getByOutAt(Time outAt) {
		return statusDayRepository.findByOutAt(outAt);
	}
//	inAt:0 : muộn
//    1: đúng giờ
//
//status: true: đang làm việc
//false: vắng
	@Override
	public StatusDay checkIn(long id) {
		StatusDay statusDay = new StatusDay();
		Calendar c = Calendar.getInstance();		
		Date date = new Date(c.getTime().getTime());
		System.out.println(c.getTime().getHours());
		Time time = new Time(c.getTime().getHours(), c.getTime().getMinutes(), c.getTime().getSeconds());	
		statusDay.setInAt(time);
		Shirt shirt = shirtRepository.findById(1).get();
		Shirt shirt2 = shirtRepository.findById(2).get();
		if(date.getTime() < shirt.getEnd().getTime() && date.getTime() > shirt.getStart().getTime()) {
			statusDay.setInStatus(0);
			statusDay.setShift(1);
		} else if(date.getTime() < shirt2.getEnd().getTime() && date.getTime() > shirt2.getStart().getTime()) {
			statusDay.setInStatus(0);
			statusDay.setShift(2);
		} else if(date.getTime() < shirt.getStart().getTime()) {
			statusDay.setInStatus(1);
			statusDay.setShift(1);
		} else if(date.getTime() < shirt2.getStart().getTime() && date.getTime() > shirt.getStart().getTime()) {
			statusDay.setInStatus(1);
			statusDay.setShift(1);
		}
		statusDay.setStatus(true);		
		List<TimeKeeping> listTimeKeepings = employeeRepository.findById(id).get().getTimeKeeping();	
		if(listTimeKeepings.size() == 0) {
			Employee employee = employeeRepository.findById(id).get();
			TimeKeeping timeKeeping = new TimeKeeping();
			employee.addTimeKeeping(timeKeeping);
			statusDay.setTimeKeeping(timeKeeping);
			timeKeeping.setEmployee(employee);
			timeKeeping.setDate(date);
			timeKeepingRepository.save(timeKeeping);
			statusDayRepository.save(statusDay);
			employeeRepository.save(employee);
		} else {
			Employee employee = employeeRepository.findById(id).get();
			Date dateOfTimeKeeping = employee.getTimeKeeping().get(employee.getTimeKeeping().size() -1).getDate();
			
			if(dateOfTimeKeeping.toString().equalsIgnoreCase(date.toString())) {
				TimeKeeping timeKeeping = employee.getTimeKeeping().get(employee.getTimeKeeping().size() -1);
				statusDay.setTimeKeeping(timeKeeping);	
				statusDayRepository.save(statusDay);
				employeeRepository.save(employee);
			} else {
				TimeKeeping timeKeeping = new TimeKeeping();
				timeKeeping.setDate(date);
				statusDay.setTimeKeeping(timeKeeping);
				timeKeeping.setEmployee(employee);
				timeKeepingRepository.save(timeKeeping);
				statusDayRepository.save(statusDay);	
				employeeRepository.save(employee);		
			}
		}

		return statusDay;
	}
	@Override
	public StatusDay checkOut(long id) {
		Calendar c = Calendar.getInstance();		
		Date date = new Date(c.getTime().getTime());
		System.out.println(c.getTime().getHours());
		Time time = new Time(c.getTime().getHours(), c.getTime().getMinutes(), c.getTime().getSeconds());
		Employee employee = employeeRepository.findById(id).get();
		Date dateOfTimeKeeping = employee.getTimeKeeping().get(employee.getTimeKeeping().size() -1).getDate();
		if(dateOfTimeKeeping.toString().equalsIgnoreCase(date.toString())) {
			TimeKeeping timeKeeping = employee.getTimeKeeping().get(employee.getTimeKeeping().size() -1);
			List<StatusDay> listStatusDays = statusDayRepository.findStatusDayByTimeKeeping(timeKeeping);
			StatusDay statusDay = listStatusDays.get(listStatusDays.size() - 1);
			statusDay.setOutAt(time);
			statusDayRepository.save(statusDay);
			return statusDay;
		} 
		
		return null;
	}
	@Override
	public List<StatusDay> getStatusDayByTimeKeeping(int idTimeKeeping) {
		List<StatusDay> statusDays = timeKeepingRepository.findById(idTimeKeeping).get().getStatusDays();
		return statusDays;
	}
	@Override
	public List<StatusDay> getByShift(int shift) {
		List<StatusDay> statusDays = statusDayRepository.findByShift(shift);
		return statusDays;
	}


}
