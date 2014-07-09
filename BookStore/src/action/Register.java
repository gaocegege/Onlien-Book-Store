package action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;  

import service.imp.UserService;
import domain.User;

public class Register extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String pwd;
	private String pwdAgain;
	private String name;
	private String sno;
	private int account;
	private String result;

	
	private UserService userService;
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	public String getPwdAgain()
	{
		return pwdAgain;
	}
	
	public void setPwdAgain(String pwdAgain)
	{
		this.pwdAgain = pwdAgain;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSno()
	{
		return sno;
	}
	
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	
	public int getAccount()
	{
		return account;
	}
	
	public void setAccount(int account)
	{
		this.account = account;
	}
	
//	public UserService getUserService()
//	{
//		return userService;
//	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return result;
	}
	
	public String checkUsername()
	{
		User user = new User();
		user.setUsername(username);
		if (userService.validateRegister(user) == false)
			result = "ERROR";
		else
			result = "AVAILABLE";
		System.out.println("Username: " + result);
		return SUCCESS;
	}
	
	public String register()
	{
		User user = new User();
		user.setUsername(username);
		user.setPwd(pwd);
		user.setName(name);
		user.setSno(sno);
		BigDecimal buf = new BigDecimal(99);
		user.setAccount(buf);
		
		if (userService.validateRegister(user) == false)
			return ERROR;
		userService.addUser(user);
		return SUCCESS;	
	}
}
