package domain;

import java.sql.Date;
import java.util.Set;

public class Orders {
	private int orderid;
	
	public int getOrderid()
	{
		return orderid;
	}
	
	public void setOrderid(int orderid)
	{
		this.orderid = orderid;
	}
	
	private Date order_date;
	
	public Date getOrder_date()
	{
		return order_date;
	}
	
	public void setOrder_date(Date order_date)
	{
		this.order_date = order_date;
	}
	
	private String username;
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	private User user;
	
	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	private Set<OrderItem> orderItem;
	
	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}
}
