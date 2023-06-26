package com.java.hibernateAndJpa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.hibernateAndJpa.dataAccess.ICityDal;
import com.java.hibernateAndJpa.entities.City;

@Service
public class CityManager implements ICityService {
	
	private ICityDal cityDal;
	
     @Autowired
	public CityManager(ICityDal cityDal) {
	
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		// TODO Auto-generated method stub
		cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		// TODO Auto-generated method stub
		cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		// TODO Auto-generated method stub
		cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		// TODO Auto-generated method stub
		return cityDal.getById(id);
	}

}
