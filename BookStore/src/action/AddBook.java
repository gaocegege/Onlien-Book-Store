package action;

import java.math.BigDecimal;

import service.imp.BookService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Book;

public class AddBook extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	private String ISBN;

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getISBN() {
		return ISBN;
	}
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookname() {
		return bookname;
	}
	
	private String bookname;

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}
	
	private String price;
	
	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
	
	private String number;
	
	public void setPublishmentName(String publishmentName) {
		this.publishmentName = publishmentName;
	}

	public String getPublishmentName() {
		return publishmentName;
	}
	
	private String publishmentName;
	
	public String execute()
	{
		BigDecimal bd=new BigDecimal(price); 
		Book book = new Book();
		book.setBookname(bookname);
		book.setISBN(ISBN);
		book.setNumber(Integer.parseInt(number));
		book.setPrice(bd);
		book.setPublishmentName(publishmentName);
		
		bookService.addBook(book);
		return SUCCESS;
	}
}
