package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.imp.BookService;
import domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Books extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int type;

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
	private BookService bookService;

	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	private int pageNum;
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}
	
	private String html;
	
	public void setHtml(String html) {
		this.html = html;
	}

	public String getHtml() {
		return html;
	}
	
	private String bookname;
	
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookname() {
		return bookname;
	}
	
	private String ISBN;
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	public String search()
	{
		List<Book> result = new ArrayList<Book>();
		System.out.println(bookname);
		if (type == 4)
		{
			System.out.println("type = 4");
			return pageView();
		}
		else if (type == 0)
		{
			System.out.println("type = 0");
			result = bookService.getBooksByName(bookname);
		}
		else if (type == 1)
		{
			System.out.println("type = 1");
			result.add(bookService.getBookById(ISBN));
		}
		int count = result.size();
	    int buf = 0;
	    html = "";
	    while (count > 0)
	    {
	    	html += "<div class='row demo-row' style = 'width:100%'>";
	    	// BUG: <4
	    	for (int i = 0; i < Math.min(3, count); i++)
	    	{
	    		Book bookBuf = result.get(buf + i);
	    		html += "<div class='col-md-4'>";
	    		html += "<div class='pallete-item' style = 'width:100%' onclick='bookinfo(";
	    		html += bookBuf.getISBN();
	    		html += ")'><dl class='palette palette-wet-asphalt'><dt>ISBN:";
	    		html += bookBuf.getISBN();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Book Name:";
	    		html += bookBuf.getBookname();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Price:";
	    		html += bookBuf.getPrice();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Number:";
	    		html += bookBuf.getNumber();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>PublishMent:";
	    		html += bookBuf.getPublishmentName();
	    		
	    		html += "</dt></dl></div>";
	    		html += "</div>";
	    	}
	    	count = count - 3;
	    	buf = buf + 3;
	    	html += "</div>";
	    }
		return SUCCESS;
	}
	
	public String pageNum()
	{
		pageNum = bookService.getMaxPage();
		return SUCCESS;
	}
	
	public String pageView()
	{
		if (pageNum >= bookService.getMaxPage())
		{
			pageNum = bookService.getMaxPage() - 1;
		}
		List<Book> result = bookService.getAllBooks(pageNum);
		int count = result.size();
	    int buf = 0;
	    html = "";
	    while (count > 0)
	    {
	    	html += "<div class='row demo-row' style = 'width:100%'>";
	    	// BUG: <4
	    	for (int i = 0; i < Math.min(3, count); i++)
	    	{
	    		Book bookBuf = result.get(buf + i);
	    		html += "<div class='col-md-4'>";
	    		html += "<div class='pallete-item' style = 'width:100%' onclick='bookinfo(";
	    		html += bookBuf.getISBN();
	    		html += ")'><dl class='palette palette-wet-asphalt'><dt>ISBN:";
	    		html += bookBuf.getISBN();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Book Name:";
	    		html += bookBuf.getBookname();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Price:";
	    		html += bookBuf.getPrice();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>Number:";
	    		html += bookBuf.getNumber();
	    		html += "</dt></dl>";
	    		html += "<dl class='palette palette-midnight-blue'><dt>PublishMent:";
	    		html += bookBuf.getPublishmentName();
	    		
	    		html += "</dt></dl></div>";
	    		html += "</div>";
	    	}
	    	count = count - 3;
	    	buf = buf + 3;
	    	html += "</div>";
	    }
		return SUCCESS;
	}

}
