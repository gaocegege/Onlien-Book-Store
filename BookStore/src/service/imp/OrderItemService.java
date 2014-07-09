package service.imp;

import dao.imp.OrderItemDAO;
import domain.OrderItem;
import service.IOrderItemService;

public class OrderItemService implements IOrderItemService {
	
	private OrderItemDAO orderItemDAO;
	
	public void setOrderItemDAO(OrderItemDAO orderItemDAO) {
		this.orderItemDAO = orderItemDAO;
	}

	public OrderItemDAO getOrderItemDAO() {
		return orderItemDAO;
	}
	
	@Override
	public void addItem(OrderItem item) {
		// TODO Auto-generated method stub
		orderItemDAO.addItem(item);
	}

	@Override
	public void updateOrder(OrderItem order) {
		// TODO Auto-generated method stub
		orderItemDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(OrderItem order) {
		// TODO Auto-generated method stub
		orderItemDAO.deleteOrder(order);
	}

	@Override
	public OrderItem getItemById(int id) {
		// TODO Auto-generated method stub
		return orderItemDAO.getItemById(id);
	}

}
