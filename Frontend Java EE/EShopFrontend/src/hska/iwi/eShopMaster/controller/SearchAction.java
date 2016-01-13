package hska.iwi.eShopMaster.controller;

import hska.iwi.eShopMaster.apiGateway.APIGateway;
import hska.iwi.eShopMaster.apiGateway.Req;
import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.CategoryManagerImpl;
import hska.iwi.eShopMaster.model.businessLogic.manager.impl.ProductManagerImpl;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;
import hska.iwi.eShopMaster.model.database.dataobjects.Product;
import hska.iwi.eShopMaster.model.database.dataobjects.User;

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
	
	User user;
	private List<Product> products;
	private List<Category> categories;
	

	public String execute() throws Exception {
		
		String result = "input";
		
		// Get user:
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User) session.get("webshop_user");
		
		
		
		
		
		if(user != null){

			if(searchMinPrice == null)
			{
				searchMinPrice=0.0;
			}
			if(searchMaxPrice == null)
			{
				searchMaxPrice=0.0;
			}
			if(searchDescription == null)
			{
				searchDescription="";
			}
			
			String pMin = String.valueOf(searchMinPrice);
			String pMax = String.valueOf(searchMaxPrice);
			String det = String.valueOf(searchDescription);
			
			
			
			
			Req myReq = APIGateway.product_list_filter_GET(pMin, pMax, det);
			
			
			if(myReq.getCode() == 404)
			{
				
			}
			else
			{
				this.products = (List<Product>)myReq.getContent();
				result = "success";
			}
			
			
			
		}
		
		return result;
	}
			
		
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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
