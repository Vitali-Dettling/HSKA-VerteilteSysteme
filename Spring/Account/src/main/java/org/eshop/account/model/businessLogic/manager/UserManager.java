package org.eshop.account.model.businessLogic.manager;

import org.eshop.account.model.database.dataobjects.Role;
import org.eshop.account.model.database.dataobjects.User;


public interface UserManager {
    
    public void registerUser(String username, String name, String lastname, String password, Role role);
    
    public User getUserByUsername(String username);
    
    public boolean deleteUserById(int id);
    
    public Role getRoleByLevel(int level);
    
    public boolean doesUserAlreadyExist(String username);
}
