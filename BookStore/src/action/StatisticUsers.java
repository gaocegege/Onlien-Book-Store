package action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import service.imp.OrdersService;

import com.opensymphony.xwork2.ActionSupport;

import domain.OrderItem;
import domain.Orders;

public class StatisticUsers extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ISBN;
	
	private String date;
	
	private List<String> userList;
	
	private List<Integer> countList;
	
	private OrdersService ordersService;
	
	public String execute()
	{
		userList = new ArrayList<String>();
		countList = new ArrayList<Integer>();
		List<Orders> ordersBuf = ordersService.getAllOrders_1(date);
		for (int i = 0; i < ordersBuf.size(); i++)
		{
			for (OrderItem item : ordersBuf.get(i).getOrderItem())
			{
				if (item.getBook().getISBN().equals(ISBN))
				{
					String buf = ordersBuf.get(i).getUser().getUsername();
					userList.add(buf);
					countList.add(item.getNumber());
				}
			}
		}
		return SUCCESS;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setCountList(List<Integer> countList) {
		this.countList = countList;
	}

	public List<Integer> getCountList() {
		return countList;
	}

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}
}
