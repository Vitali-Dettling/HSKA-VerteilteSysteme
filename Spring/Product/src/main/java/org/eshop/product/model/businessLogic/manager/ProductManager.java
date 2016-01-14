package org.eshop.product.model.businessLogic.manager;

import org.eshop.product.model.database.dataobjects.Product;

import java.util.List;

public interface ProductManager {

	public List<Product> getProducts();

	public Product getProductById(int id);

	public Product getProductByName(String name);

	public int addProduct(String name, double price, int categoryId, String details);

	public List<Product> getProductsForSearchValues(String searchValue, Double searchMinPrice, Double searchMaxPrice);
	
	public boolean deleteProductsByCategoryId(int categoryId);
	
    public void deleteProductById(int id);
    
	
}