package action;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import service.imp.OrderItemService;
import service.imp.OrdersService;
import service.imp.BookService;
import service.imp.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.BasketItem;
import domain.Book;
import domain.OrderItem;
import domain.Orders;

public class Bargain extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrdersService ordersService;
	
	public void setOrdersService(OrdersService ordersService) 
	{
		this.ordersService = ordersService;
	}

	public OrdersService getOrdersService() 
	{
		return ordersService;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	private BookService bookService;
	
	public BookService getBookService()
	{
		return bookService;
	}
	
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	private OrderItemService orderItemService;
	
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	public OrderItemService getOrderItemService() {
		return orderItemService;
	}
	
	private int bookid;

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public int getBookid() {
		return bookid;
	}
	
	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	
	public String execute()
	{
		SimpleDateFormat sy1=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		sy1.format(date);
		System.out.println(date);
		Map<String, Object> session = ActionContext.getContext().getSession();
		List<BasketItem> result = (List<BasketItem>) session.get("basket");
		String username = (String) session.get("username");
		Orders order = new Orders();
		order.setOrder_date(date);
		order.setUser(userService.getUserByID(username));
		ordersService.addOrder(order);
		int id = order.getOrderid();
		for (Iterator it = result.iterator();it.hasNext();)
		{
			BasketItem buf = (BasketItem) it.next();
			OrderItem orderBuf = new OrderItem();
			orderBuf.setBook(bookService.getBookById(buf.getISBN()));
			orderBuf.setNumber(buf.getCount());
			orderBuf.setOrder(order);
			orderItemService.addItem(orderBuf);
		}
		session.remove("basket");
		return SUCCESS;
	}
}
