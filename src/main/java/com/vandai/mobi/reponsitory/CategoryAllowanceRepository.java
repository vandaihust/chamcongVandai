package com.vandai.mobi.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vandai.mobi.model.CategoryAllowance;
@Repository
public interface CategoryAllowanceRepository extends JpaRepository<CategoryAllowance, Integer> {
	public CategoryAllowance findByCategory(String category);
}
