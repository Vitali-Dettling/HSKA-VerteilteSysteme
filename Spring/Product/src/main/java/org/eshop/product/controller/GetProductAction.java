package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

public class GetProductAction {
	
	private static final long serialVersionUID = 39979991339088L;

	public Response getProductById(String id) throws JSONException {

		ProductManager productManager = new ProductManagerImpl();

		Product p = productManager.getProductByName(id);
		
		if(p == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		
		
		
		
			JSONObject jo = new JSONObject();
			
			jo.put("id", p.getId());
			jo.put("name", p.getName());
			jo.put("price", p.getPrice());
			jo.put("details", p.getDetails());
			jo.put("category", p.getCategory().getName());
			

		
		
		return Response.ok(jo.toString()).build();
	}

	
	
	
}
