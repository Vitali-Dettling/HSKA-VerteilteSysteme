package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;

public class AddCategoryAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6704600867133294378L;

	public Response addCategory(String name) throws Exception {

		if (name.length() < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		CategoryManager categoryManager = new CategoryManagerImpl();
		categoryManager.addCategory(name);
			
		return Response.ok().build();
	
	}	
}
