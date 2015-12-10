package org.eshop.product.controller;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.CategoryManagerImpl;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6565401833074694229L;
	
	
	private String searchDescription = null;
	private Double searchMinPrice = null;
	private Double searchMaxPrice = null;
	
	private List<Product> products;
	private List<Category> categories;
	

	public String execute() throws Exception {
		
		String result = "input";
		
		// Get user:
//		Map<String, Object> session = ActionContext.getContext().getSession();
//		user = (User) session.get("webshop_user");
//		
//		
//		if(user != null){
//			// Search products and show results:
//			ProductManager productManager = new ProductManagerImpl();
//			this.products = productManager.getProductsForSearchValues(this.searchDescription, this.searchMinPrice, this.searchMaxPrice);
//			
//			// Show all categories:
//			CategoryManager categoryManager = new CategoryManagerImpl();
//			this.categories = categoryManager.getCategories();
//			result = "success";
//		}
		
		return result;
	}
	
		
		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}
		
		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}
		
		


	public String getSearchValue() {
		return searchDescription;
	}


	public void setSearchValue(String searchValue) {
		this.searchDescription = searchValue;
	}


	public Double getSearchMinPrice() {
		return searchMinPrice;
	}


	public void setSearchMinPrice(Double searchMinPrice) {
		this.searchMinPrice = searchMinPrice;
	}


	public Double getSearchMaxPrice() {
		return searchMaxPrice;
	}


	public void setSearchMaxPrice(Double searchMaxPrice) {
		this.searchMaxPrice = searchMaxPrice;
	}
}
