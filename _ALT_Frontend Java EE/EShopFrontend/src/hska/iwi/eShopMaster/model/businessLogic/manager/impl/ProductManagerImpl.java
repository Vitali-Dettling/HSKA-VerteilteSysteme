package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;
import hska.iwi.eShopMaster.model.database.dataobjects.Product;

import java.util.List;

public class ProductManagerImpl implements ProductManager {



	@Override
	public List<Product> getProducts() {
		return null;
	}
	
	@Override
	public List<Product> getProductsForSearchValues(String searchDescription,
			Double searchMinPrice, Double searchMaxPrice) {	
		return null;
	}

	@Override
	public Product getProductById(int id) {
		return null;
	}

	@Override
	public Product getProductByName(String name) {
		return null;
	}
	
	@Override
	public int addProduct(String name, double price, int categoryId, String details) {
		int productId = -1;
		
		CategoryManager categoryManager = new CategoryManagerImpl();
		Category category = categoryManager.getCategory(categoryId);
		
		if(category != null){
			Product product;
			if(details == null){
				product = new Product(name, price,  String.valueOf(categoryId));	
			} else{
				product = new Product(name, price, String.valueOf(categoryId), details);
			}
			
			//
			productId = product.getId();
		}
			 
		return productId;
	}
	

	@Override
	public void deleteProductById(int id) {
		//
	}

	@Override
	public boolean deleteProductsByCategoryId(int categoryId) {
		return false;
	}

}
