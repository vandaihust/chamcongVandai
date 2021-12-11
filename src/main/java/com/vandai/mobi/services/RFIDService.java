package com.vandai.mobi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Rfid;
import com.vandai.mobi.reponsitory.EmployeeRepository;
import com.vandai.mobi.reponsitory.RFIDRepository;
import com.vandai.mobi.services.impl.RFIDServiceImpl;

@Service
public class RFIDService implements RFIDServiceImpl{
	@Autowired
	RFIDRepository rFIDRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Rfid addRFID(Rfid rfid, long idEmployee) {
		rfid.setEmployee(employeeRepository.findById(idEmployee).get());
		rFIDRepository.save(rfid);
		return rfid;
	}

	@Override
	public List<Rfid> getAllRFID() {
		return rFIDRepository.findAll();
	}

	@Override
	public Rfid updateRFID(Rfid rfid, long idEmployee) {
		rfid.setId(employeeRepository.findById(idEmployee).get().getRfid().getId());
		rfid.setEmployee(employeeRepository.findById(idEmployee).get());
		rFIDRepository.save(rfid);
		return rfid;
	}

	@Override
	public String deleteRFID(int id) {
		if(rFIDRepository.existsById(id)) {
			rFIDRepository.deleteById(id);
			return "Delete RFID successfully";
		}
		return "Delete RFID fail";
	}

	@Override
	public Rfid getRFIDById(int id) {
		return rFIDRepository.findById(id).get();
	}

	@Override
	public List<Rfid> getRFIDByStatus(int status) {
		return rFIDRepository.findByStatus(status);
	}

	@Override
	public Rfid getRFIDByEmployee(long id) {
		return rFIDRepository.findByEmployee(employeeRepository.findById(id).get());
	}

}
