package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCategoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1254575994729199914L;
	
	public ResponseEntity<String> deleteCategory(String id) {
	
		if (id.length() < 0) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		}
		// Helper inserts new Category in DB:
		CategoryManager categoryManager = new CategoryManagerImpl();
		
		Category category = categoryManager.getCategoryByName(id);
	
		if(category == null || category.getId() < 0){
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		}
		
		categoryManager.delCategory(category);
			
		return new ResponseEntity<String>("", HttpStatus.OK);//Response.ok().build();
		
	}
}
