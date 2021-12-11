package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.Rfid;

public interface RFIDServiceImpl {
	public Rfid addRFID(Rfid rfid, long idEmployee);
	public List<Rfid> getAllRFID();
	public Rfid updateRFID(Rfid rfid, long idEmployee);
	public String deleteRFID(int id);
	public Rfid getRFIDById(int id);
	public List<Rfid> getRFIDByStatus(int status);
	public Rfid getRFIDByEmployee(long id);
}
