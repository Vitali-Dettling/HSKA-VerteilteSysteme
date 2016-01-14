package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddCategoryAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6704600867133294378L;

	public ResponseEntity<String> addCategory(String name) {

		if (name.length() < 0) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//ResponseEntityResponse.status(Status.NOT_FOUND).build();
		}
		
		CategoryManager categoryManager = new CategoryManagerImpl();
		categoryManager.addCategory(name);
			
		return new ResponseEntity<String>("", HttpStatus.OK);
	
	}	
}
