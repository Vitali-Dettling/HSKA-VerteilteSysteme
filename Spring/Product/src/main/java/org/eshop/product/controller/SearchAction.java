package org.eshop.product.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6565401833074694229L;


	private List<Product> products;
	private List<Category> categories;

	public Response execute(String details, double priceMin, double priceMax) throws Exception {

		// Search products and show results:
		ProductManager productManager = new ProductManagerImpl();
		products = productManager.getProductsForSearchValues(details, priceMin, priceMax);

//		// Show all categories:
//		CategoryManager categoryManager = new CategoryManagerImpl();
//		this.categories = categoryManager.getCategories();
		
		
		if(products == null || products.size() <= 0){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		JSONArray ja = new JSONArray();
		
		for(Product p : products)
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
