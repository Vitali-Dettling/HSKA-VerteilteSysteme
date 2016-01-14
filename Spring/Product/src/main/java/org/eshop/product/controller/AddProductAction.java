package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddProductAction {

	private static final long serialVersionUID = 39979991339088L;

	public ResponseEntity<String> addProduct(String sp) {

		Product p = new Product();	
		JSONObject product = null;
		try {
			
			product = new JSONObject(sp);
			
			p.setDetails(product.getString("details"));
			p.setName(product.getString("name"));
			p.setPrice(product.getDouble("price"));
			p.setId(-1);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	
		CategoryManager cm = new CategoryManagerImpl();
		
		try {
			p.setCategory(cm.getCategoryByName(product.getString("category")));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
			
		if (!validate(p)) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//Response.status(Status.NOT_FOUND).build();
		}

		ProductManager productManager = new ProductManagerImpl();
		int productId = productManager.addProduct(p.getName(), p.getPrice(), p.getCategory().getId(), p.getDetails());

		if (productId < 0) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//Response.status(Status.NOT_FOUND).build();
		}

		return new ResponseEntity<String>("", HttpStatus.OK);//Response.ok().build();
	}

	private boolean validate(Product product) {

		if(product == null){
			return false;
		}
		
		String id = product.getName();
		
		if (id == null || id.length() == 0) {
			return false;
		}

		if (product.getCategory() == null) {
			return false;
		}

		String price = String.valueOf(product.getPrice());
		if (price.length() > 0) {
			if (!price.matches("[0-9]+(.[0-9][0-9]?)?") || Double.parseDouble(price) < 0.0) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
