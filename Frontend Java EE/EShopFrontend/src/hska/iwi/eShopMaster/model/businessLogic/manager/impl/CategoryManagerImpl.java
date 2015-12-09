package hska.iwi.eShopMaster.model.businessLogic.manager.impl;


import hska.iwi.eShopMaster.model.businessLogic.manager.CategoryManager;
import hska.iwi.eShopMaster.model.database.dataobjects.Category;

import java.util.List;

public class CategoryManagerImpl implements CategoryManager{



	@Override
	public List<Category> getCategories() {
		return null;
	}

	@Override
	public Category getCategory(int id) {
		return null;
	}

	@Override
	public Category getCategoryByName(String name) {
		return null;
	}

	@Override
	public void addCategory(String name) {
		Category cat = new Category(name);
		//

	}

	@Override
	public void delCategory(Category cat) {


		//
	}

	@Override
	public void delCategoryById(int id) {
		
		//
	}
}
