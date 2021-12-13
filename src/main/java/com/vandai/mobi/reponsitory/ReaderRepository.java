package com.vandai.mobi.reponsitory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Reader;
@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer>{
	public List<Reader> findByNameContaining(String name);
	public List<Reader> findByAddressContaining(String address);
	public List<Reader> findByStatus(int status);
	public Reader findByIdReader(String id);
	public List<Reader> findByDateBuy(Date dateBuy);
	public List<Reader> findByAddressSupply(String address);
	public List<Reader> findByDepartmentUse(String departmentUse);
}


//status:
//	0: hỏng
//	1: đang hoạt động