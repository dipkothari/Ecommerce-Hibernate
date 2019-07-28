package com.cart.dao;

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

import com.cart.model.cartModel;
import com.cart.model.cartModelCk;




public class cartpDao {
	public List<cartModel> getProduct(String username) {
	List<cartModel> cartlist = null;
	EntityManager em = null;
	try {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query q = em.createQuery("select c from cartModel c where c.username=?1");
		
		q.setParameter(1, username);
		
		cartlist = q.getResultList();

		
	}
	catch(Exception e) {
		
	}
	return cartlist;
	}
}
