package org.eshop.product.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetCategoryAction {
	
	private static final long serialVersionUID = -6704600867133294378L;

	public ResponseEntity<String> getCategories() {

		CategoryManager categoryManager = new CategoryManagerImpl();
		List<Category> categories = categoryManager.getCategories();
		
		if(categories == null){
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		}
		
		JSONArray ja = new JSONArray();
		
		for(Category cat : categories)
		{
			JSONObject jo = new JSONObject();
			try {
				jo.put("id", cat.getName());
				jo.put("name", cat.getId());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ja.put(jo);
		}
		
		return new ResponseEntity<String>(ja.toString(), HttpStatus.OK);//Response.ok(ja.toString()).build();
	
	}	

}