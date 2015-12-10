package org.eshop.account.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.eshop.account.model.database.dataobjects.Role;
import org.eshop.account.model.database.dataobjects.User;

public class LoginAction {

	/**
	 *
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private User user;

	public Response execute(String userName, String pass) throws Exception {

		UserManager myCManager = new UserManagerImpl();

		// Get user from DB:
		this.user = myCManager.getUserByUsername(userName);

		// Does user exist?
		if (this.user != null && user.getUsername().equals(userName)) {
			// Is the password correct?
			if (user.getPassword().equals(pass)) {
				boolean role = getUserRole();
				return Response.ok(role).build();
			}else{
				return Response.status(Status.UNAUTHORIZED).build();
			}
		}else{
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	public boolean getUserRole() {

		Role role = this.user.getRole();

		if (role.getTyp().equals("1")) {
			return false;
		} else {
			return true;
		}
	}


}