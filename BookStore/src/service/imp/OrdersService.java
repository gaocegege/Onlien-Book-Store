package service.imp;

import java.util.List;
import java.util.Set;

import domain.OrderItem;
import domain.Orders;
import service.IOrdersService;
import dao.imp.OrdersDAO;

public class OrdersService implements IOrdersService {
	private OrdersDAO ordersDAO;
	
	public OrdersDAO getOrdersDAO()
	{
		return ordersDAO;
	}
	
	public void setOrdersDAO(OrdersDAO ordersDAO)
	{
		this.ordersDAO = ordersDAO;
	}
	@Override
	public void addOrder(Orders order) {
		// TODO Auto-generated method stub
		ordersDAO.addOrder(order);
	}

	@Override
	public void updateOrder(Orders order) {
		// TODO Auto-generated method stub
		ordersDAO.updateOrder(order);

	}

	@Override
	public void deleteOrder(Orders order) {
		// TODO Auto-generated method stub
		ordersDAO.deleteOrder(order);
	}

	@Override
	public Orders getOrderById(int id) {
		// TODO Auto-generated method stub
		return ordersDAO.getOrderById(id);
	}

	@Override
	public List<Orders> getAllOrders(String username) {
		// TODO Auto-generated method stub
		return ordersDAO.getAllOrders(username);
	}
	
	public List<Orders> getAllOrders_1(String date)
	{
		return ordersDAO.getAllOrders_1(date);
	}
	
	public Set<OrderItem> viewItem(int id)
	{
		return ordersDAO.viewItem(id);
	}

}
