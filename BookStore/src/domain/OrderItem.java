package domain;

public class OrderItem {
	private int itemid;
	
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getItemid() {
		return itemid;
	}
	
	private int orderid;

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getOrderid() {
		return orderid;
	}
	
	private String ISBN;
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getISBN() {
		return ISBN;
	}
	
	private int number;
	
	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
	
	private Book book;
	
	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	private Orders order;
	
	public void setOrder(Orders order) {
		this.order = order;
	}

	public Orders getOrder() {
		return order;
	}
	
	public OrderItem()
	{
		
	}
}
