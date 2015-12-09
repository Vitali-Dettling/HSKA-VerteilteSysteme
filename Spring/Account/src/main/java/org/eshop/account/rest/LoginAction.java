package org.eshop.account.rest;

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.eshop.account.model.database.dataobjects.Role;
import org.eshop.account.model.database.dataobjects.User;
import org.eshop.account.rest.MessageHandler.StatusCode;

public class LoginAction {

	/**
	 *
	 */
	private static final long serialVersionUID = -983183915002226000L;

	private User user;

	public StatusCode execute(String userName, String pass) throws Exception {

		UserManager myCManager = new UserManagerImpl();

		// Get user from DB:
		this.user = myCManager.getUserByUsername(userName);

		// Does user exist?
		if (this.user != null && user.getUsername().equals(userName)) {
			// Is the password correct?
			if (user.getPassword().equals(pass)) {
				return StatusCode.OK;
			}else{
				return StatusCode.unauthorizedLogin;
			}
		}else{
			return StatusCode.userNotFound;
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
