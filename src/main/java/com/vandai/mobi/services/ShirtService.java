package com.vandai.mobi.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandai.mobi.model.Shirt;
import com.vandai.mobi.reponsitory.ShirtRepository;
import com.vandai.mobi.services.impl.ShirtServiceImpl;
@Service
public class ShirtService implements ShirtServiceImpl{
	@Autowired
	ShirtRepository shirtRepository;
	@Override
	public Shirt addShirt(Shirt shirt) {
		shirtRepository.save(shirt);
		return shirt;
	}

	@Override
	public List<Shirt> getAllShirt() {
		List<Shirt> list = shirtRepository.findAll();
		return list;
	}

	@Override
	public Shirt updateShirt(Shirt shirt, int id) {
		shirt.setId(id);
		shirtRepository.save(shirt);
		return shirt;
	}

	@Override
	public String deleteShirt(int id) {
		if(shirtRepository.existsById(id)) {
			shirtRepository.deleteById(id);
			return "Delete Succesfully";
		}
		return "Delete fail";
	}

	@Override
	public Shirt getShirtById(int id) {
		return shirtRepository.findById(id).get();
	}

	@Override
	public List<Shirt> fakeDataShirt() {
		List<Shirt> shirts = new ArrayList<Shirt>();
		Shirt shirt1 = new Shirt();
		
		shirt1.setName(1);
	
		shirt1.setStart(new Time(8,0,0));
		shirt1.setEnd(new Time(12,0,0));
		shirtRepository.save(shirt1);
		shirts.add(shirt1);
		return shirts;
	}

}
