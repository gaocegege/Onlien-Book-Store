package action;

import java.util.Map;
import java.util.Set;

import service.imp.OrdersService;
import service.imp.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Orders;
import domain.User;

public class ViewOrder extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrdersService ordersService;

	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}

	public OrdersService getOrdersService() {
		return ordersService;
	}
	
	private UserService userService;
	
	public UserService getUserService()
	{
		return userService;
	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
//		Set<Orders> result = ((User) session.get("user")).getOrders();
		Set<Orders> result = userService.getUserByID(username).getOrders();
		session.remove("orders");
		session.put("orders", result);
		return SUCCESS;
	}
}
