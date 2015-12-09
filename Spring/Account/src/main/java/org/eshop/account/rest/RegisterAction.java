package org.eshop.account.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.eshop.account.model.database.dataobjects.Role;
import org.eshop.account.model.database.dataobjects.User;

public class RegisterAction {

    /**
     *
     */
    private static final long serialVersionUID = 3655805600703279195L;
    
    public Response execute(String user, String pass) throws Exception {
        
    	final int USER = 1;
       
    	UserManager userManager = new UserManagerImpl();	
    
   		if (!userManager.doesUserAlreadyExist(user)) {
    		    	
	        // save it to database
   			Role role = userManager.getRoleByLevel(USER); // regular User = 1, no admin = 0
	        userManager.registerUser(user, "", "", pass, role);
	            // User has been saved successfully to databse:
	            return Response.ok().build();
    	}else{
    		return Response.status(Status.NOT_FOUND).build();
    	}
    }
}