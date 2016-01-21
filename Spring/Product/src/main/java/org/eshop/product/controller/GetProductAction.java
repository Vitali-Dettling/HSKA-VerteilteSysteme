package org.eshop.product.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetProductAction {
	
	private static final long serialVersionUID = 39979991339088L;

	public ResponseEntity<String> getProductById(String id) {

		ProductManager productManager = new ProductManagerImpl();

		Product p = productManager.getProductByName(id);
		
		if(p == null){
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//Response.status(Status.NOT_FOUND).build();
		}
			JSONObject jo = new JSONObject();
		
			try {
				jo.put("id", p.getId());
				jo.put("name", p.getName());
				jo.put("price", p.getPrice());
				jo.put("details", p.getDetails());
				jo.put("category", p.getCategory().getName());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return new ResponseEntity<String>(jo.toString(), HttpStatus.OK);//Response.ok(jo.toString()).build();
	}

	
	
	
}