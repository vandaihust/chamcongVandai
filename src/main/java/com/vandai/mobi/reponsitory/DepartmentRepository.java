package com.vandai.mobi.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, String>{
	
}
