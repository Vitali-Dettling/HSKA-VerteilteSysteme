package org.eshop.product.model.businessLogic.manager;

import java.util.List;

import org.eshop.product.model.database.dataobjects.Category;

public interface CategoryManager {

	public List<Category> getCategories();
	
	public Category getCategory(int id);
	
	public Category getCategoryByName(String name);
	
	public void addCategory(String name);
	
	public void delCategory(Category cat);
	
	public void delCategoryById(int id);

	
}
