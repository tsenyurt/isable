package com.tsenyurt.twitbot;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tsenyurt.db.model.User;
import com.tsenyurt.db.util.HibernateUtil;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class TwitbotMain {
	public static void main(){
		Session session = HibernateUtil.getSessionFactory().openSession();

		TwitterFactory factory = new TwitterFactory();
		Twitter twt = factory.getInstance();
		//twt.getFollowersList(arg0, arg1);
		
		listUsers(session);
		HibernateUtil.shutdown();

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
