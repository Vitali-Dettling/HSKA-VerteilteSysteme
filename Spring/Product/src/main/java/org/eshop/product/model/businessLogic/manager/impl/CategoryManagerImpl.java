package org.eshop.product.model.businessLogic.manager.impl;


import java.util.List;

import org.eshop.product.model.businessLogic.manager.CategoryManager;
import org.eshop.product.model.database.dataAccessObjects.CategoryDAO;
import org.eshop.product.model.database.dataobjects.Category;

public class CategoryManagerImpl implements CategoryManager{
	private CategoryDAO helper;
	
	public CategoryManagerImpl() {
		helper = new CategoryDAO();
	}

	@Override
	public List<Category> getCategories() {
		return helper.getObjectList();
	}

	@Override
	public Category getCategory(int id) {
		return helper.getObjectById(id);
	}

	@Override
	public Category getCategoryByName(String name) {
		return helper.getObjectByName(name);
	}

	@Override
	public void addCategory(String name) {
		Category cat = new Category(name);
		helper.saveObject(cat);

	}

	@Override
	public void delCategory(Category cat) {
	
// 		Products are also deleted because of relation in Category.java 
		helper.deleteById(cat.getId());
	}

	@Override
	public void delCategoryById(int id) {
		
		helper.deleteById(id);
	}
}
