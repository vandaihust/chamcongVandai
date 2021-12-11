package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.CategoryAllowance;

public interface CategoryAllowanceImpl {
	public CategoryAllowance addCategoryAllowance(CategoryAllowance categoryAllowance);
	public CategoryAllowance updateCategoryAllowance(int id, CategoryAllowance categoryAllowance);
	public String deleteCategoryAllowance(int id);
	public List<CategoryAllowance> getAllCategoryAllowance();
	public CategoryAllowance getCategoryAllowanceById(int id);
	public CategoryAllowance getCategoryAllowanceByCategory(String category);
}
