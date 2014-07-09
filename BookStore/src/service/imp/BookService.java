package service.imp;

import java.util.List;
import java.util.Set;

import domain.Book;
import domain.OrderItem;
import service.IBookService;
import dao.imp.BookDAO;

public class BookService implements IBookService {
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}
	
	public BookDAO getBookDAO()
	{
		return bookDAO;
	}
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null)
			return;
		
		if (bookDAO.getBookById(book.getISBN()) != null)
			return;
		
		bookDAO.addBook(book);		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null)
			return;
		
		if (bookDAO.getBookById(book.getISBN()) == null)
			return;
		
		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		if (book == null)
			return;
		
		if (bookDAO.getBookById(book.getISBN()) == null)
			return;
		
		bookDAO.deleteBook(book);
	}

	@Override
	public Book getBookById(String ISBN) {
		// TODO Auto-generated method stub
		return bookDAO.getBookById(ISBN);
	}
	
	public List<Book> getBooksByName(String bookname)
	{
		return bookDAO.getBooksByName(bookname);
	}
	
	public List<Book> getAllBooks(int pageNum)
	{
		return bookDAO.getAllBooks(pageNum);
	}
	
	public Set<OrderItem> viewItem(String ISBN)
	{
		return bookDAO.viewItem(ISBN);
	}
	
	public int getMaxPage()
	{
		return bookDAO.getMaxPage();
	}
}
