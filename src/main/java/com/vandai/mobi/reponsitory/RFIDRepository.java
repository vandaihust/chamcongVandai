package com.vandai.mobi.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Employee;
import com.vandai.mobi.model.Rfid;

@Repository
public interface RFIDRepository extends JpaRepository<Rfid, Integer>{
	public List<Rfid> findByStatus(int status);
	public Rfid findByEmployee(Employee employee);
}
//status:
//	0: bị mất
//	1: đang sử dụng
//	2: bị hỏng