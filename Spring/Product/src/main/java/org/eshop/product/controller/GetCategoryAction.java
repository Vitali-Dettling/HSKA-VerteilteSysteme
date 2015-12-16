package org.eshop.product.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
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
		
		JSONArray ja = new JSONArray();
		
		for(Category cat : categories)
		{
			JSONObject jo = new JSONObject();
			jo.put("id", cat.getName());
			jo.put("name", cat.getId());
			
			ja.put(jo);
		}
		
		return Response.ok(ja.toString()).build();
	
	}	

}
