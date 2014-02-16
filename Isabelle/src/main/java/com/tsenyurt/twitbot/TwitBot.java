package com.tsenyurt.twitbot;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

import com.tsenyurt.db.model.User;
import com.tsenyurt.db.util.HibernateUtil;

public class TwitBot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		createUsers(session);
		listUsers(session);
		
		

		TwitterFactory factory = new TwitterFactory();
		Twitter twt = factory.getInstance();
		
		HibernateUtil.shutdown();

	}
	
	public static void createUsers(Session session){
		Transaction tx = session.beginTransaction();
		for (int i = 0; i < 20; i++) {
			User user = new User();
			user.setName("apple_" + i);
			user.setPassword("123456_" + i);
			
			session.save(user);
			
			
		}
		tx.commit();	
	
	}
	
	   /* Method to  READ all the employees */
	   public static void listUsers( Session session){
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List<User> users = session.createQuery("FROM User").list(); 
	         for (Iterator<User> iterator = 
	                           users.iterator(); iterator.hasNext();){
	            User user = (User) iterator.next(); 
	            System.out.print("ID: " + user.getId()); 
	            System.out.print("Name: " + user.getName()); 
	            System.out.println("Password: " + user.getPassword()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   }

}
