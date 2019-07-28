package com.cart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cart.model.cartModel;
import com.cart.model.cartModelCk;



public class cartDao {
	public void addCart(String username,int id,String name,double price,int quantity) {
		
	//	int rowcount=0;
		
		EntityManager em = null;
		try {
			double total = price*quantity;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("project");
			em = emf.createEntityManager();
			em.getTransaction().begin();
			
			cartModelCk cmck = new cartModelCk(username,id);
			
			cartModel cm = em.find(cartModel.class, cmck);
			
			if(cm!=null) {
			//	rowcount=st.executeUpdate("update cart set productquantity='"+quantity+"', productprice='"+total+"' where username='"+username+"' and productid='"+id+"'");
				cm.setProductquantity(quantity);
				cm.setProductprice(total);
				em.getTransaction().commit();
			}
			else
			{
				//rowcount=st.executeUpdate("INSERT INTO cart VALUES ('"+username+"','"+id+"', '"+name+"', '"+total+"', '"+quantity+"')");
				//em.persist(username,id,name,total,quantity);
				cartModel cm1 = new cartModel();
				cm1.setUsername(username);
				cm1.setProductid(id);
				cm1.setProductname(name);
				cm1.setProductprice(total);
				cm1.setProductquantity(quantity);
				em.persist(cm1);
				em.getTransaction().commit();

			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	//	return rowcount;
		
	}
}
