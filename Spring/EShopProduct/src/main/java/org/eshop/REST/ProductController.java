package org.eshop.REST;

import org.eshop.core.ProductAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

/*
 /product/{id}
GET /product/{id}
PUT /product/{id}
DELETE /product/{id}
*/
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String getProduct() {
		return new ProductAPI().getProduct();
	}
	
	@RequestMapping(value = "/product{id}", method = RequestMethod.PUT)
	public String createProduct() {
		ProductAPI pro = new ProductAPI();
		pro.setProduct("TODO get from SOAP message");
		return pro.getProduct();
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public String deleteProduct() {
		ProductAPI pro = new ProductAPI();
		pro.setCategory("");
		return "TODO Delete Product";
	}
	
/*
/product/
POST /product/
GET /product/
 */
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProducts() {
		return new ProductAPI().getProduct();
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String addCategory() {
		ProductAPI pro = new ProductAPI();
		pro.setCategory("TODO get from SOAP message");
		return pro.getCategory();
	}

	
}
