package com.vandai.mobi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.CategoryAllowance;
import com.vandai.mobi.reponsitory.CategoryAllowanceRepository;
import com.vandai.mobi.services.impl.CategoryAllowanceImpl;

@Service
public class CategoryAllowanceService implements CategoryAllowanceImpl{
	@Autowired
	CategoryAllowanceRepository categoryAllowanceRepository;
	@Override
	public CategoryAllowance addCategoryAllowance(CategoryAllowance categoryAllowance) {
		categoryAllowanceRepository.save(categoryAllowance);
		return categoryAllowance;
	}

	@Override
	public CategoryAllowance updateCategoryAllowance(int id, CategoryAllowance categoryAllowance) {
		categoryAllowance.setId(id);
		categoryAllowanceRepository.save(categoryAllowance);
		return categoryAllowance;
	}

	@Override
	public String deleteCategoryAllowance(int id) {
		if(categoryAllowanceRepository.existsById(id)) {
			categoryAllowanceRepository.deleteById(id);
			return "Delete category allowance succesfully";
		}
		return "Delete category allowance fail";
	}

	@Override
	public List<CategoryAllowance> getAllCategoryAllowance() {
		return categoryAllowanceRepository.findAll();
	}

	@Override
	public CategoryAllowance getCategoryAllowanceById(int id) {
		return categoryAllowanceRepository.findById(id).get();
	}

	@Override
	public CategoryAllowance getCategoryAllowanceByCategory(String category) {
		return categoryAllowanceRepository.findByCategory(category);
	}

}
