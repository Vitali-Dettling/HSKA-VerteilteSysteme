package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.businessLogic.manager.UserManager;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.RoleDAO;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.UserDAO;
import hska.iwi.eShopMaster.model.database.dataobjects.Role;
import hska.iwi.eShopMaster.model.database.dataobjects.User;

/**
 * 
 * @author knad0001
 */

public class UserManagerImpl implements UserManager {
	UserDAO helper;
	
	public UserManagerImpl() {
		helper = new UserDAO();
	}

	
	@Override
	public void registerUser(String username, String name, String lastname, String password, Role role) {

		User user = new User(username, name, lastname, password, role);

		helper.saveObject(user);
	}

	
	@Override
	public User getUserByUsername(String username) {
		if (username == null || username.equals("")) {
			return null;
		}
		return helper.getUserByUsername(username);
	}

	@Override
	public boolean deleteUserById(int id) {
		User user = new User();
		user.setId(id);
		helper.deleteObject(user);
		return true;
	}

	@Override
	public Role getRoleByLevel(int level) {
		RoleDAO roleHelper = new RoleDAO();
		return roleHelper.getRoleByLevel(level);
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
		if (user.getFirstname().isEmpty() || user.getPassword().isEmpty() || user.getRole() == null || user.getLastname() == null || user.getUsername() == null) {
			return false;
		}
		
		return true;
	}

}
