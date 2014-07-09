package service;

import domain.OrderItem;
import domain.Orders;
import java.util.List;
import java.util.Set;

public interface IOrdersService {
	
	public void addOrder(Orders order);
	
	public void updateOrder(Orders order);
	
	public void deleteOrder(Orders order);
	
	public Orders getOrderById(int id);
	
	public List<Orders> getAllOrders(String username);
	
	public List<Orders> getAllOrders_1(String date);
	
	public Set<OrderItem> viewItem(int id);
}
