package action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import service.imp.BookService;
import service.imp.OrdersService;

import com.opensymphony.xwork2.ActionSupport;

import domain.OrderItem;
import domain.Orders;

public class Statistic extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> dateList;
	
	private List<Integer> dataList;
	
	private String ISBN;
	
	public String getISBN()
	{
		return ISBN;
	}
	
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BookService getBookService() {
		return bookService;
	}
	
	private OrdersService ordersService;
	
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}
	
	public String execute()
	{
		dateList = new ArrayList<String>();
		dataList = new ArrayList<Integer>();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sy1=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		sy1.format(date);
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		for (int i = 0; i < 7; i++)
		{
			int count = 0;
			c.set(Calendar.DATE, day - i);
			dateList.add(sy1.format(c.getTime()));
			List<Orders> resultBuf =  ordersService.getAllOrders_1(sy1.format(c.getTime()));
			for (int j = 0; j < resultBuf.size(); j++)
			{
				for (OrderItem item : resultBuf.get(j).getOrderItem())
				{
					if (item.getBook().getISBN().equals(ISBN))
					{
						count = count + item.getNumber();
					}
				}
			}
			dataList.add(count);
		}
		return SUCCESS;
	}

	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	public List<String> getDateList() {
		return dateList;
	}

	public void setDataList(List<Integer> dataList) {
		this.dataList = dataList;
	}

	public List<Integer> getDataList() {
		return dataList;
	}
}
