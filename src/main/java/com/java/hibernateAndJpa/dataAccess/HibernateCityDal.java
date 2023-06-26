package com.java.hibernateAndJpa.dataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.hibernateAndJpa.entities.City;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateCityDal implements ICityDal{
	
	private EntityManager entityManager;
	
	
     @Autowired
	public HibernateCityDal(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
     

	@Override
	@Transactional
	public List<City> getAll() {
		Session session=entityManager.unwrap(Session.class);
		List<City> cities=session.createQuery("from City", City.class).getResultList();
	 	
		return cities;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void add(City city) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void delete(City city) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		City cityToDelete=session.get(City.class,city.getId());
		session.delete(cityToDelete);
		
	}


	@Override
	public City getById(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		City city=session.get(City.class, id);
	  
		return city;
	}
	

}
