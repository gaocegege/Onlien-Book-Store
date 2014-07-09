package service.imp;

import java.util.Set;

import domain.Orders;
import domain.User;
import service.IUserService;
import dao.imp.UserDAO;

public class UserService implements IUserService {
	//业务逻辑层实现
	private UserDAO userDAO;
	
	public UserService(){}
	
	public UserService(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	public UserDAO getUserDAO()
	{
		return userDAO;
	}
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		if (user == null)
			return;
		
		if (user.getUsername() == null)
			return;
		//may have bugs
		//already have~?
		userDAO.addUser(user);
	}

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		if (user == null)
			return;
		
		if (user.getUsername() == null)
			return;
		
		userDAO.deleteUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		if (user == null)
			return;
		
		if (user.getUsername() == null)
			return;
		
		userDAO.updateUser(user);
	}


	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		if (id == null)
			return null;
		
		return userDAO.getUserById(id);
	}


	public boolean validateUser(String username, String pwd) {
		User userBuf = userDAO.getUserById(username);
		if (pwd.equals(userBuf.getPwd()))
			return true;
		else
			return false;
	}
	
	public boolean validateRegister(User user)
	{
		// can be updated
		if (userDAO.getUserById(user.getUsername()) != null)
			return false;
		return true;
	}
	
	public Set<Orders> ViewOrders(String username)
	{
		return userDAO.ViewOrders(username);
	}
}
