package com.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cart.model.cartModel;
import com.cart.model.cartModelCk;

public class removeCart {
	public void remCart(String username,int id) {
		EntityManager em = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		//	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/deep","root","Kothari_1");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			//Statement st = con.createStatement();			
			
			/*
			 * Query q = em.
			 * createQuery("delete from cartModel c where c.username=?1 and c.productid=?2"
			 * ); q.setParameter(1,username); q.setParameter(2, id); q.executeUpdate();
			 * em.getTransaction().commit();
			 */
			
			 cartModelCk cmck = new cartModelCk(username,id);
			 
			 cartModel cm = em.find(cartModel.class, cmck);
			 em.remove(cm);
			 em.getTransaction().commit();
			
		}
		catch(Exception e) {
			
		}	
		
	}
}
