package com.vandai.mobi.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Reader;
import com.vandai.mobi.reponsitory.ReaderRepository;
import com.vandai.mobi.services.impl.ReaderServiceImpl;

@Service
public class ReaderService implements ReaderServiceImpl{
	@Autowired
	ReaderRepository readerRepository;
	@Override
	public Reader addReader(Reader reader) {
		readerRepository.save(reader);
		return reader;
	}

	@Override
	public List<Reader> getAllReader() {
		return readerRepository.findAll();
	}

	@Override
	public Reader updateReader(Reader reader, int id) {
		reader.setId(id);
		readerRepository.save(reader);
		return reader;
	}

	@Override
	public String deleteReader(int id) {
		if(readerRepository.existsById(id)) {
			readerRepository.deleteById(id);
			return "Delete reader successfully";
		}
		return "Delete reader fail";
	}

	@Override
	public Reader getReaderById(int id) {
		return readerRepository.findById(id).get();
	}

	@Override
	public Reader getReaderByIdReader(String idReader) {
		return readerRepository.findByIdReader(idReader);
	}

	@Override
	public List<Reader> getByNameContaining(String name) {
		return readerRepository.findByNameContaining(name);
	}

	@Override
	public List<Reader> getByAddressContaining(String address) {
		return readerRepository.findByAddressContaining(address);
	}

	@Override
	public List<Reader> getByStatus(int status) {
		return readerRepository.findByStatus(status);
	}

	@Override
	public List<Reader> getByDateBy(Date dateBuy) {
		return readerRepository.findByDateBuy(dateBuy);
	}

	@Override
	public List<Reader> getByAddressSupply(String addressSupply) {
		return readerRepository.findByAddressSupply(addressSupply);
	}

	@Override
	public List<Reader> getByDepartmentUse(String departmentUse) {
		return readerRepository.findByDepartmentUse(departmentUse);
	}

}
