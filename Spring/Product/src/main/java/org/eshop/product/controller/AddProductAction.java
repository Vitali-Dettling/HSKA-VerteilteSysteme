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

public class AddProductAction {

	private static final long serialVersionUID = 39979991339088L;

	public Response addProduct(String sp) throws JSONException {

		JSONObject product = new JSONObject(sp);
		
		Product p = new Product();	
		
		
		p.setDetails(product.getString("details"));
		p.setName(product.getString("name"));
		p.setPrice(product.getDouble("price"));
		p.setId(-1);
		
	
		CategoryManager cm = new CategoryManagerImpl();
		
		p.setCategory(cm.getCategoryByName(product.getString("category")));
		
			
		if (!validate(p)) {
			return Response.status(Status.NOT_FOUND).build();
		}

		ProductManager productManager = new ProductManagerImpl();
		int productId = productManager.addProduct(p.getName(), p.getPrice(), p.getCategory().getId(), p.getDetails());

		if (productId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().build();
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
