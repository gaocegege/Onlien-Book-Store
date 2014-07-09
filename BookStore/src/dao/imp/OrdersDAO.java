package dao.imp;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dao.IOrdersDAO;
import domain.Book;
import domain.OrderItem;
import domain.Orders;

public class OrdersDAO implements IOrdersDAO {
	
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
	public void addOrder(Orders order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(order);
		tx.commit();
		session.close();
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(order);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteOrder(Orders order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(order);
		tx.commit();
		session.close();
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return (Orders) session.get(Orders.class, id);
	}

	@Override
	public List<Orders> getAllOrders(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		Criteria cr = session.createCriteria(Orders.class);
//		List<Orders> result = cr.add(Restrictions.eq('username', username));
		
//		String sqlQuery = "select * from orders where username = '";
//		sqlQuery += username;
//		sqlQuery += "'";
//		SQLQuery query = session.createSQLQuery(sqlQuery);
//		query.addEntity(Orders.class);
//		List<Orders> result = query.list();
		String hql="from Orders as j where j.user.username ='";
		hql += username;
		hql += "'";
        Query query=session.createQuery(hql); 
//        query.setInteger(0,com_id); 
        List<Orders> result = query.list();
		tx.commit();
		session.close();
		return result;
	}
	
	public List<Orders> getAllOrders_1(String date)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hql="from Orders as j where j.order_date ='";
		hql += date;
		hql += "'";
        Query query=session.createQuery(hql); 
//        query.setInteger(0,com_id); 
        List<Orders> result = query.list();
		tx.commit();
		session.close();
		return result;
	}
	
	public Set<OrderItem> viewItem(int id)
	{
		Orders order = this.getOrderById(id);
		return order.getOrderItem();
	}
}
