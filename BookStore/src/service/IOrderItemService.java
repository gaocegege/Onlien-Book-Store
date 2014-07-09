package service;

import domain.OrderItem;

public interface IOrderItemService {
	public void addItem(OrderItem item);
	
	public void updateOrder(OrderItem order);
	
	public void deleteOrder(OrderItem order);
	
	public OrderItem getItemById(int id);
}
