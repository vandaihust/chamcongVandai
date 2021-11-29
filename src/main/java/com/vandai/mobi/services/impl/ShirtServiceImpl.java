package com.vandai.mobi.services.impl;

import java.util.List;

import com.vandai.mobi.model.Shirt;

public interface ShirtServiceImpl {
	public Shirt addShirt(Shirt shirt);
	public List<Shirt> getAllShirt();
	public Shirt updateShirt(Shirt shirt, int id);
	public String deleteShirt(int id);
	public Shirt getShirtById(int id);
	public List<Shirt> fakeDataShirt();
}
