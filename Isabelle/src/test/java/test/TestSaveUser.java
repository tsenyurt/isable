package test;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tsenyurt.db.model.User;
import com.tsenyurt.db.util.HibernateUtil;

public class TestSaveUser extends TestCase{

	public void testSave(){
		User user = new User();
		user.setName("apple");
		user.setPassword("123456");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}
