package com.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.product.model.productModel;

public class checkoutDao {
	public String checkout(String username) {
		
			EntityManager em = null;
		try {
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
		
			Query q = em.createQuery("select c.productquantity , c.productid from cartModel c where c.username=?1");
			q.setParameter(1, username);
			List l = q.getResultList();
			
			int rs = l.size();

			
			for(int i=0; i<rs; i++){
				Object[] obj= (Object[]) l.get(i);
				
				int cartcount = (Integer) obj[0];//5
				int cartid = (Integer) obj[1];//2
			
				Query q1 = em.createQuery("select p from productModel p where p.productid=?1");
				q1.setParameter(1, cartid);
				List l1 = q1.getResultList();
				int rs1 = l1.size();
				if(rs1!=0) {
					productModel p =(productModel) l1.get(0);
					int productcount = p.getProductquantity();
					
					int totalcount = productcount-cartcount;
					if(totalcount>=0) {
					
						Query q2 = em.createQuery("update productModel p set p.productquantity=?1 where p.productid =?2");
						q2.setParameter(1, totalcount);
						q2.setParameter(2, cartid);
						q2.executeUpdate();
					}
					
					else {
						return "Sorry";
					}
					
				}
			}
			em.getTransaction().commit();
			//Statement st3 = con.createStatement();
			em.getTransaction().begin();
			 Query q3 = em.createQuery("delete from cartModel c where c.username=?1");
			 q3.setParameter(1, username);
			 q3.executeUpdate();
			 em.getTransaction().commit();
		//	st3.executeUpdate("delete from cart where username='"+username+"'"); 
			
			
		}
		catch(Exception e) {
			
		}
		return username;
	}
}
