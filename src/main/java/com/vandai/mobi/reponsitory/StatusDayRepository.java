package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.StatusDay;
import com.vandai.mobi.model.TimeKeeping;
@Repository
public interface StatusDayRepository extends JpaRepository<StatusDay, Integer> {
	public List<StatusDay> findStatusDayByTimeKeeping(TimeKeeping timeKeeping);
	public StatusDay findByInStatus(int inStatus);
	public StatusDay findByOutStatus(int outStatus);
	public StatusDay findByStatus(int status);
	public StatusDay findByInAt(Date inAt);
	public StatusDay findByOutAt(Date outAt);
}
