package org.eshop.product.controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAllProductsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94109228677381902L;
	
	
	public ResponseEntity<String> getProducts(){
		
		ProductManager productManager = new ProductManagerImpl();
		List<Product> productList = productManager.getProducts();
		
		JSONArray ja = new JSONArray();
		
		
		if(productList == null){
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//Response.status(Status.NOT_FOUND).build();
		}
		
		for(Product p : productList)
		{
			JSONObject jo = new JSONObject();
			
			try {
				jo.put("id", p.getId());
				jo.put("name", p.getName());
				jo.put("price", p.getPrice());
				jo.put("details", p.getDetails());
				jo.put("category", p.getCategory().getName());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			ja.put(jo);
		}
		
		return new ResponseEntity<String>(ja.toString(), HttpStatus.OK);//Response.ok(ja.toString()).build();
	}

}
