package org.eshop.account.controller;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.eshop.account.model.database.dataobjects.Role;
import org.eshop.account.model.database.dataobjects.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginAction {

	/**
	 *
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private User user;

	public  ResponseEntity<Boolean> execute(String userName, String pass) {

		UserManager myCManager = new UserManagerImpl();

		// Get user from DB:
		this.user = myCManager.getUserByUsername(userName);

		// Does user exist?
		if (this.user != null && user.getUsername().equals(userName)) {
			// Is the password correct?
			if (user.getPassword().equals(pass)) {
				boolean role = getUserRole();
				return new ResponseEntity<Boolean>(role, HttpStatus.OK);
			}else{
				return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);//throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).entity("auth failed").type(MediaType.TEXT_PLAIN).build());
				
			}
		}else{
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
			//return Response.status(Status.NOT_FOUND).build();
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