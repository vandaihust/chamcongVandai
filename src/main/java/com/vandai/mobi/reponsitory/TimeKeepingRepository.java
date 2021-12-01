package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.TimeKeeping;
@Repository
public interface TimeKeepingRepository extends JpaRepository<TimeKeeping, Integer>{
	public List<TimeKeeping> findByDate(Date date);
	public List<TimeKeeping> findByStatusOfDay(int statusDay);
	public List<TimeKeeping> findByHour(Long hour);
	public List<TimeKeeping> findByEmployee(Employee employee);
	
}
