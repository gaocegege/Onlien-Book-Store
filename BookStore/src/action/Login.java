package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  

import domain.User;

import service.imp.UserService;

public class Login extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String pwd;
	private UserService userService;
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPwd()
	{
		return this.pwd;
	}
	
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	public UserService getUserService()
	{
		return this.userService;
	}
	
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	
	public String execute()
	{
		System.out.println(username + ":" + pwd);
		if (username.equals("") || pwd.equals(""))
		{
			return ERROR;
		}
		
		if (userService.validateUser(username, pwd) == false)
		{
			return ERROR;
		}
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("username", username);
		return SUCCESS;
	}
}
