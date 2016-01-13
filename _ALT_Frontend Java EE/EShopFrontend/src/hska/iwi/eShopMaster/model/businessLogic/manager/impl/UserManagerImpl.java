package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.model.database.dataobjects.xRole;
import hska.iwi.eShopMaster.model.database.dataobjects.User;

/**
 * 
 * @author knad0001
 */

public class UserManagerImpl implements UserManager {
	

	
	@Override
	public void registerUser(String username, String name, String lastname, String password, boolean role) {

		User user = new User(username, name, lastname, password, role);

		//
	}

	
	@Override
	public User getUserByUsername(String username) {
		if (username == null || username.equals("")) {
			return null;
		}
		return null;
	}

	@Override
	public boolean deleteUserById(int id) {
		User user = new User();
		user.setId(id);
		//
		return true;
	}

	@Override
	public boolean doesUserAlreadyExist(String username) {
		
    	User dbUser = this.getUserByUsername(username);
    	
    	if (dbUser != null){
    		return true;
    	}
    	else {
    		return false;
    	}
	}
	

	public boolean validate(User user) {
		if (user.getFirstname().isEmpty() || user.getPassword().isEmpty() || user.getLastname() == null || user.getUsername() == null) {
			return false;
		}
		
		return true;
	}

}
