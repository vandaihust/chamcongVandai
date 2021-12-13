package com.vandai.mobi.services.impl;

import java.sql.Date;
import java.util.List;

import com.vandai.mobi.model.Reader;

public interface ReaderServiceImpl {
	public Reader addReader(Reader reader);
	public List<Reader> getAllReader();
	public Reader updateReader(Reader reader, int id);
	public String deleteReader(int id);
	public Reader getReaderById(int id);
	public Reader getReaderByIdReader(String idReader);
	public List<Reader> getByNameContaining(String name);
	public List<Reader> getByAddressContaining(String address);
	public List<Reader> getByStatus(int status);
	public List<Reader> getByDateBy(Date dateBuy);
	public List<Reader> getByAddressSupply(String addressSupply);
	public List<Reader> getByDepartmentUse(String departmentUse);
}
