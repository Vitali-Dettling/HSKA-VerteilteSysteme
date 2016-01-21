package org.eshop.product.controller;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6565401833074694229L;


	private List<Product> products;
	private List<Category> categories;

	public ResponseEntity<String> execute(String details, double priceMin, double priceMax) {

		// Search products and show results:
		ProductManager productManager = new ProductManagerImpl();
		products = productManager.getProductsForSearchValues(details, priceMin, priceMax);

//		// Show all categories:
//		CategoryManager categoryManager = new CategoryManagerImpl();
//		this.categories = categoryManager.getCategories();
		
		
		if(products == null || products.size() <= 0){
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
		}
		
		JSONArray ja = new JSONArray();
		
		for(Product p : products)
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