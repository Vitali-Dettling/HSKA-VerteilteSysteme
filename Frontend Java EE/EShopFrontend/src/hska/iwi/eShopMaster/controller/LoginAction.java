package hska.iwi.eShopMaster.controller;

import hska.iwi.eShopMaster.apiGateway.APIGateway;
import hska.iwi.eShopMaster.apiGateway.Req;
import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.UserManagerImpl;
import hska.iwi.eShopMaster.model.database.dataobjects.xRole;
import hska.iwi.eShopMaster.model.database.dataobjects.User;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -983183915002226000L;
	private String username = null;
	private String password = null;

	
	public void reset() throws Exception
	{
		this.username = "";
		this.password = "";
	}
	
	@Override
	public String execute() throws Exception {

		// Return string:
		String result = "input";

		Req myReq = APIGateway.account_GET(getUsername(), getPassword());
				
		
		if(myReq.getCode() == 200)
		{
			User usr = new User(getUsername(), "","",getPassword(),(boolean)myReq.getContent());
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			
			// Save user object in session:
			session.put("webshop_user", usr);
			result = "success";
		}
		else if(myReq.getCode() == 401)
		{
			addActionError(getText("error.password.wrong"));
		}
		else if(myReq.getCode() == 404)
		{
			addActionError(getText("error.username.wrong"));
		}
		
		return result;
	}
	
	@Override
	public void validate() {
		if (getUsername().length() == 0) {
			addActionError(getText("error.username.required"));
		}
		if (getPassword().length() == 0) {
			addActionError(getText("error.password.required"));
		}
	}

	public String getUsername() {
		return (this.username);
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return (this.password);
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
