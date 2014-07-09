package service;

import java.util.Set;

import domain.Orders;
import domain.User;

public interface IUserService {
	// 业务逻辑层接口
	public void addUser(User user);
	
	public void deleteUser(User user);
	
	public void updateUser(User user);
	
	public User getUserByID(String id);
	
	public boolean validateUser(String username, String pwd);
	
	public boolean validateRegister(User user);
	
	public Set<Orders> ViewOrders(String username);
}
