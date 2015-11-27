package org.eshop.REST;

import org.eshop.core.ProductAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@SessionAttributes(types = CategoryController.class)
public class CategoryController {

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String getCategory() {
		return new ProductAPI().getCategory();
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String createCategory() {
		ProductAPI pro = new ProductAPI();
		pro.setCategory("TODO get from SOAP message");
		return pro.getCategory();
	}

	@RequestMapping(value = "/category", method = RequestMethod.DELETE)
	public String deleteCategory() {
		ProductAPI pro = new ProductAPI();
		pro.setCategory("");
		return "TODO Delete category";
	}

}
