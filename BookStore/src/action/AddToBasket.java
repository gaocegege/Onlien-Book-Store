package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.imp.BookService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.BasketItem;
import domain.OrderItem;

public class AddToBasket extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<BasketItem> items;
	
	public List<BasketItem> getItems()
	{
		return items;
	}
	
	public void setItems(List<BasketItem> items)
	{
		this.items = items;
	}
	
	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}
	
	private String ISBN;
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getISBN() {
		return ISBN;
	}
	
	public String execute()
	{
		BasketItem item = new BasketItem();
		item.setISBN(ISBN);
		item.setCount(count);
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.containsKey("basket") == false)
		{
			items = new ArrayList<BasketItem>();
			items.add(item);
		}
		else
		{
			this.setItems((List<BasketItem>)session.get("basket"));
			session.remove("basket");
			for (int i = 0; i < items.size(); i++)
			{
				if (items.get(i).getISBN().equals(ISBN))
				{
					item = items.get(i);
					items.remove(i);
					int totalCount = item.getCount() + count;
					item.setCount(totalCount);
					items.add(item);
					session.put("basket", items);
					return SUCCESS;
				}
			}
			items.add(item);
		}
		session.put("basket", items);
		return SUCCESS;
	}

}
