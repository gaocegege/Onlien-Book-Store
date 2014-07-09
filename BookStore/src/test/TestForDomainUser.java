package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import domain.User;

public class TestForDomainUser {
	public static void main(String[] args)
	{
		Configuration config = new Configuration();
		config = config.configure();
		@SuppressWarnings("deprecation")
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User one = null;
		one = (User)session.get(User.class, "cece1");
		System.out.println(one.getPwd());
		transaction.commit();
		session.close();
	}

}
