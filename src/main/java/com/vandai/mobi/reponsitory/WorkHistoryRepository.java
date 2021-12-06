package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Position;
import com.vandai.mobi.model.WorkHistory;
@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long>{
	public List<WorkHistory> findByEmployee(Employee employee);
	public List<WorkHistory> findByPosition(Position position);
	public List<WorkHistory> findByStartAt(Date startAt);
	public List<WorkHistory> findByEndAt(Date endAt);
}
