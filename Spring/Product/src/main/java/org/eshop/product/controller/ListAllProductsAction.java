package org.eshop.product.controller;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

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
	
	
	public Response getProducts() throws JSONException {
		
		ProductManager productManager = new ProductManagerImpl();
		List<Product> productList = productManager.getProducts();
		
		JSONArray ja = new JSONArray();
		
		
		if(productList == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		for(Product p : productList)
		{
			JSONObject jo = new JSONObject();
			
			jo.put("id", p.getId());
			jo.put("name", p.getName());
			jo.put("price", p.getPrice());
			jo.put("details", p.getDetails());
			jo.put("category", p.getCategory().getName());
			
			ja.put(jo);
		}
		
		return Response.ok(ja.toString()).build();
	}

}
