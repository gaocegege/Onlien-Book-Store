package dao;

import domain.Book;
import domain.OrderItem;

import java.util.List;
import java.util.Set;

public interface IBookDAO {
	
	public void addBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(Book book);
	
	public Book getBookById(String ISBN);
	
	public List<Book> getBooksByName(String bookname);
	
	public List<Book> getAllBooks(int pageNum);
	
	public Set<OrderItem> viewItem(String ISBN);
	
	public int getMaxPage();
}
