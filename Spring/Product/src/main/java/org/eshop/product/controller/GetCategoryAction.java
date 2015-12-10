package org.eshop.product.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;

public class GetCategoryAction {
	
	private static final long serialVersionUID = -6704600867133294378L;

	public Response getCategories() throws Exception {

		CategoryManager categoryManager = new CategoryManagerImpl();
		List<Category> categories = categoryManager.getCategories();
		
		if(categories == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(categories).build();
	
	}	

}
