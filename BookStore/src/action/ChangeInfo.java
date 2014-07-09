package action;

import java.util.Map;

import service.imp.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;

public class ChangeInfo extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private String pwd;
	private String pwdAgain;
	private String name;
	private String sno;

	public void setUserService(UserService userService) 
	{
		this.userService = userService;
	}

	public UserService getUserService() 
	{
		return userService;
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
	
	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String username = (String) session.get("username");
		User user = new User();
		String testString = "";
		user = userService.getUserByID(username);
		
		if ((!pwd.equals(testString)) && pwd.equals(pwdAgain))
			user.setPwd(pwd);
		
		if (!name.equals(testString))
			user.setName(name);
		
		if (!sno.equals(testString))
			user.setSno(sno);
		
		userService.updateUser(user);
		
		return SUCCESS;
	}
}
