package org.eshop.product.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eshop.product.controller.AddCategoryAction;
import org.eshop.product.controller.DeleteCategoryAction;
import org.eshop.product.controller.GetCategoryAction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class CategoryAPI {

//	@POST
//	@Path("/category")
//	@Consumes("application/json")
//	@Produces("application/json")
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestHeader("name") String name) {

		AddCategoryAction addCategory = new AddCategoryAction();
		ResponseEntity<String> response = addCategory.addCategory(name);
		return response;
	}

	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<String> getCategories() {
		// W O R K S
		GetCategoryAction getCategory = new GetCategoryAction();
		ResponseEntity<String> response = getCategory.getCategories();
		return response;
	}

//	@DELETE
//	@Path("/category/{id}")
//	@Consumes("application/json")
//	@Produces("application/json")
	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {
		DeleteCategoryAction delete = new DeleteCategoryAction();
		ResponseEntity<String> response = delete.deleteCategory(id);
	}
}