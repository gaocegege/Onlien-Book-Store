package dao.imp;

//import org.hibernate.Criteria;  
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;  
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Repository;  
import dao.IBookDAO;
import domain.Book;
import domain.OrderItem;

public class BookDAO implements IBookDAO {
	
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
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(book);
		tx.commit();
		session.close();
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(book);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(book);
		tx.commit();
		session.close();
	}

	@Override
	public Book getBookById(String ISBN) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		return (Book) session.get(Book.class, ISBN);
	}
	
	public List<Book> getBooksByName(String bookname)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql="From Book where bookname='";
		hql += bookname;
		hql += "'";
		Query q = session.createQuery(hql);
//		q.setFirstResult(0);
//		q.setMaxResults(9);
		List<Book> result = q.list();
		tx.commit();
		session.close();
		return result;
	}
	
	public List<Book> getAllBooks(int pageNum)
	{
		// Size : 9
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(" From Book");
		q.setFirstResult(9 * pageNum);
		q.setMaxResults(9);
		List<Book> result = q.list();
		tx.commit();
		session.close();
		return result;
	}
	
	public Set<OrderItem> viewItem(String ISBN)
	{
		Book book = this.getBookById(ISBN);
		return book.getOrderItem();
	}
	
	public int getMaxPage()
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query q = session.createQuery(" From Book");
		List<Book> result = q.list();
		int page = 0;
		if (result.size() % 9 == 0)
		{
			page = result.size() / 9;
		}
		else
		{
			page = result.size() / 9 + 1;
		}
		System.out.println("The page total count: " + page);
		tx.commit();
		session.close();
		return page;
	}
}
