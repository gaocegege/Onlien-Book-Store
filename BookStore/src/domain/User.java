package domain;

import java.math.BigDecimal;
import java.util.Set;

public class User {
	private String username = null;
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	private String pwd = null;
	
	public String getPwd()
	{
		return pwd;
	}
	
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	private String sno;
	
	public String getSno()
	{
		return sno;
	}
	
	public void setSno(String sno)
	{
		this.sno = sno;
	}
	
	private BigDecimal account;
	
	public BigDecimal getAccount()
	{
		return account;
	}
	
	public void setAccount(BigDecimal account)
	{
		this.account = account;
	}
	
	private Set<Orders> orders;
	
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<Orders> getOrders() {
		return orders;
	}
}

