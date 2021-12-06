package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.WorkHistory;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.PositionRepository;
import com.vandai.mobi.reponsitory.WorkHistoryRepository;
import com.vandai.mobi.services.impl.WorkHistoryServiceImpl;

@Service
public class WorkHistoryService implements WorkHistoryServiceImpl{
	@Autowired
	WorkHistoryRepository workHistoryRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	PositionRepository positionRepository;
	@Override
	public WorkHistory addWorkHistory(long idEmployee, int idPosition, WorkHistory workHistory) {
		workHistory.setEmployee(employeeRepository.findById(idEmployee).get());
		workHistory.setPosition(positionRepository.findById(idPosition).get());
		workHistoryRepository.save(workHistory);
		return workHistory;
	}

	@Override
	public WorkHistory updateWorkHistory(long idEmployee, int idPosition, long idWorkHistory, WorkHistory workHistory) {
		workHistory.setId(idWorkHistory);
		workHistory.setPosition(positionRepository.findById(idPosition).get());
		workHistory.setEmployee(employeeRepository.findById(idEmployee).get());
		workHistoryRepository.save(workHistory);
		return workHistory;
	}

	@Override
	public String deleteWorkHistory(long idWorkHistory) {
		if(workHistoryRepository.existsById(idWorkHistory)) {
			workHistoryRepository.deleteById(idWorkHistory);
			return "Delete workHistory Successfully";
		}
		return "Delete WorkHistory fail";
	}

	@Override
	public List<WorkHistory> getByStartAt(Date startAt) {
		List<WorkHistory> histories = workHistoryRepository.findByStartAt(startAt);
		return histories;
	}

	@Override
	public List<WorkHistory> getByEndAt(Date endAt) {
		List<WorkHistory> histories = workHistoryRepository.findByEndAt(endAt);
		return histories;
	}

	@Override
	public List<WorkHistory> getByEmployee(long idEmployee) {
		List<WorkHistory> histories = workHistoryRepository.findByEmployee(employeeRepository.findById(idEmployee).get());
		return histories;
	}

	@Override
	public List<WorkHistory> getByPosition(int idPosition) {
		List<WorkHistory> histories = workHistoryRepository.findByPosition(positionRepository.findById(idPosition).get());
		return histories;
	}

}
