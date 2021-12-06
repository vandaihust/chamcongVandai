package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.WorkHistory;

public interface WorkHistoryServiceImpl {
	public WorkHistory addWorkHistory(long idEmployee,int idPosition, WorkHistory workHistory);
	public WorkHistory updateWorkHistory(long idEmployee,int idPosition,long idWorkHistory, WorkHistory workHistory);
	public String deleteWorkHistory(long idWorkHistory);
	public List<WorkHistory> getByStartAt(Date startAt);
	public List<WorkHistory> getByEndAt(Date endAt);
	public List<WorkHistory> getByEmployee(long idEmployee);
	public List<WorkHistory> getByPosition(int idPosition);
}
