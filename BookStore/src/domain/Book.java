package domain;

import java.math.BigDecimal;
import java.util.Set;

public class Book {
	
	private String ISBN;
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getISBN() {
		return ISBN;
	}
	
	private String bookname;
	
	public String getBookname()
	{
		return bookname;
	}
	
	public void setBookname(String bookname)
	{
		this.bookname = bookname;
	}
	
	private BigDecimal price;
	
	public BigDecimal getPrice()
	{
		return price;
	}
	
	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}
	
	private int number;
	
	public int getNumber()
	{
		return number;
	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	private String publishmentName;
	
	public String getPublishmentName()
	{
		return publishmentName;
	}
	
	public void setPublishmentName(String publishmentName)
	{
		this.publishmentName = publishmentName;
	}

	private Set<OrderItem> orderItem;
	
	public void setOrderItem(Set<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public Set<OrderItem> getOrderItem() {
		return orderItem;
	}
}
