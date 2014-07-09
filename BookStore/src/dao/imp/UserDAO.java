package dao.imp;

//import org.hibernate.Criteria;  
import java.util.Set;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;  
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Repository;  
import dao.IUserDAO;
import domain.Orders;
import domain.User;

public class UserDAO implements IUserDAO {
	
	private SessionFactory sessionFactory;  
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public UserDAO()
	{
		
	}
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		User buf =  (User) session.get(User.class, id);
		session.close();
		return buf;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		session.close();
	}
	
	public Set<Orders> ViewOrders(String username)
	{
		User user = this.getUserById(username);
		return user.getOrders();
	}
}
