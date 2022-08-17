package com.ty.manytomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomany.dto.Car;
import com.ty.manytomany.dto.Feature;

public class TestFeatureCar {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Car car = new Car();
		car.setBrand("Audi");
		car.setCost("9700000");
		
		Car car2 = new Car();
		car2.setBrand("BMW");
		car2.setCost("30000000");
		
		List<Car> list = new ArrayList<Car>();
		Feature f1 = new Feature();
		f1.setType("Curise Control");
		f1.setCost("876543");
		f1.setCar(list);
		
		transaction.begin();
		manager.persist(f1);
		manager.persist(car);
		manager.persist(car2);
		transaction.commit();
		System.out.println("data added");
	}

}
