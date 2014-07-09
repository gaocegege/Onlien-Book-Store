package dao;

import java.util.Set;

import domain.Orders;
import domain.User;

public interface IUserDAO {
	
	public void addUser(User user);
	
	public void deleteUser(User user);
	
	public User getUserById(String id);
	
	public void updateUser(User user);
	
	public Set<Orders> ViewOrders(String username);
}
