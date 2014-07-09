package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.imp.BookService;
import domain.Book;
import java.util.List;
import java.util.Map;

public class StatisticBooks extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService;
	
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	private List<Book> result;
	
	public void setResult(List<Book> result) {
		this.result = result;
	}

	public List<Book> getResult() {
		return result;
	}
	
	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	
	private String html;
	
	public void setHtml(String html) {
		this.html = html;
	}

	public String getHtml() {
		return html;
	}
	
	private int pageNum;
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}
	
	public String execute()
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
