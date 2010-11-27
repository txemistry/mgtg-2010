package iso3.pt.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport
{
	public String logout()
	{
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

}
