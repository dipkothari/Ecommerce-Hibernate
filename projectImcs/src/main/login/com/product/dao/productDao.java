package com.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.product.model.productModel;
public class productDao {
	
	
	public List<productModel> getProduct() {
		List<productModel> productlist =null;
		EntityManager em = null;
		
		try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query rs = em.createQuery("select p from productModel p");
		
		productlist = rs.getResultList();
		
		
	}
	catch(Exception e) {
		
	}
	return productlist;
	}
}
