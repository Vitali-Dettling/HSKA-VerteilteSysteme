package hska.iwi.eShopMaster.model.businessLogic.manager.impl;


import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.database.dataAccessObjects.CategoryDAO;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;

import java.util.List;

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
