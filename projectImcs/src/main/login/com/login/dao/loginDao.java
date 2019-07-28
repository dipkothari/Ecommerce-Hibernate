package com.login.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class loginDao {
	
		
		
		public boolean check(String name, String pass) throws SQLException, ClassNotFoundException {
			System.out.println(name+"1");
			EntityManager em = null;
			
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
			
			em = emf.createEntityManager();
			em.getTransaction().begin();
				Query q = null;
				q = em.createQuery("select u from check u where u.uname=?1 and u.pass=?2");
				System.out.println(name+"2");
			q.setParameter(1, name);
			q.setParameter(2, pass);
			System.out.println(name+"3");
			List l = (List) q.getResultList();
			System.out.println(name+"4");
			System.out.println(l);
				if(l.isEmpty()) {
					return false;
				}
				else {
					return true;
				}
	
		}
}
