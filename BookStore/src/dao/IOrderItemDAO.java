package dao;

import domain.OrderItem;

public interface IOrderItemDAO {
	public void addItem(OrderItem item);
	
	public void updateOrder(OrderItem order);
	
	public void deleteOrder(OrderItem order);
	
	public OrderItem getItemById(int id);
}
