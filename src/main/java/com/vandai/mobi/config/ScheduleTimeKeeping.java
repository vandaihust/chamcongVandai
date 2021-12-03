package com.vandai.mobi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;
import com.vandai.mobi.services.StatusDayService;
import com.vandai.mobi.services.TimeKeepingService;

@Component
public class ScheduleTimeKeeping {
	@Autowired
	TimeKeepingService timeKeepingService;
	@Autowired
	StatusDayService statusDayService;
	
	@Scheduled(fixedRate = 10000)
	public void caculateHourOfWork(){
		List<TimeKeeping> listTimeKeepings = timeKeepingService.getAllTimeKeeping();
		for (TimeKeeping timeKeeping : listTimeKeepings) {
			List<StatusDay> statusDays = statusDayService.getStatusDayByTimeKeeping(timeKeeping.getId());
			long time = 0;
			for (StatusDay statusDay : statusDays) {
				long c = statusDay.getOutAt().getTime() - statusDay.getInAt().getTime();
				time += c;
			}
			time = time /1000;
			timeKeeping.setHour(time);//đơn vị giây
				
			if(time>0) timeKeeping.setStatusOfDay(1);//đi làm
			else if (time == 0) timeKeeping.setStatusOfDay(0);//vắng
				
			timeKeepingService.updateTimeKeeping(timeKeeping, timeKeeping.getId());
			}
			
		System.out.println(listTimeKeepings);
	}
}
