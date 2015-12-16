package hska.iwi.eShopMaster.model.businessLogic.manager.impl;

import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.businessLogic.manager.ProductManager;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.ProductDAO;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;
import hska.iwi.eShopMaster.model.database.dataobjects.Product;

import java.util.List;

public class ProductManagerImpl implements ProductManager {
	private ProductDAO helper;
	
	public ProductManagerImpl() {
		helper = new ProductDAO();
	}

	@Override
	public List<Product> getProducts() {
		return helper.getObjectList();
	}
	
	@Override
	public List<Product> getProductsForSearchValues(String searchDescription,
			Double searchMinPrice, Double searchMaxPrice) {	
		return new ProductDAO().getProductListByCriteria(searchDescription, searchMinPrice, searchMaxPrice);
	}

	@Override
	public Product getProductById(int id) {
		return helper.getObjectById(id);
	}

	@Override
	public Product getProductByName(String name) {
		return helper.getObjectByName(name);
	}
	
	@Override
	public int addProduct(String name, double price, int categoryId, String details) {
		int productId = -1;
		
		CategoryManager categoryManager = new CategoryManagerImpl();
		Category category = categoryManager.getCategory(categoryId);
		
		if(category != null){
			Product product;
			if(details == null){
				product = new Product(name, price, category);	
			} else{
				product = new Product(name, price, category, details);
			}
			
			helper.saveObject(product);
			productId = product.getId();
		}
			 
		return productId;
	}
	

	@Override
	public void deleteProductById(int id) {
		helper.deleteById(id);
	}

	@Override
	public boolean deleteProductsByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

}
