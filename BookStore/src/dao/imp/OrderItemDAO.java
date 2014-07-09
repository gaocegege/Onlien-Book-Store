package dao.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IOrderItemDAO;
import domain.OrderItem;
import domain.Orders;

public class OrderItemDAO implements IOrderItemDAO {
	
	private SessionFactory sessionFactory;  
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addItem(OrderItem item) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(item);
		tx.commit();
		session.close();
	}

	@Override
	public void updateOrder(OrderItem order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(order);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteOrder(OrderItem order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(order);
		tx.commit();
		session.close();
	}

	@Override
	public OrderItem getItemById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return (OrderItem) session.get(Orders.class, id);
	}

}
