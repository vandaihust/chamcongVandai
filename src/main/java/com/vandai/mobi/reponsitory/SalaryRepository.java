package com.vandai.mobi.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.Salary;
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer>{

}
