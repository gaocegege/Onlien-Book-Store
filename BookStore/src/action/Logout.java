package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {
	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		// Çå³ýsession
		session.clear();
		return SUCCESS;
	}
}
