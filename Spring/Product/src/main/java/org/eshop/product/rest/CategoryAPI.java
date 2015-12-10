package org.eshop.product.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eshop.product.controller.AddCategoryAction;
import org.eshop.product.controller.DeleteCategoryAction;
import org.eshop.product.controller.GetCategoryAction;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class CategoryAPI {

	@POST
	@Path("/category")
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(String name) throws Exception {

		AddCategoryAction addCategory = new AddCategoryAction();
		Response response = addCategory.addCategory(name);
		return response;
	}

	@GET
	@Path("/category")
	@Consumes("application/json")
	@Produces("application/json")
	public Response getCategories() throws Exception {

		GetCategoryAction addCategory = new GetCategoryAction();
		Response response = addCategory.getCategories();
		return response;
	}

	@DELETE
	@Path("/category/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(@PathParam(value = "id") String id) throws Exception {

		DeleteCategoryAction delete = new DeleteCategoryAction();
		Response response = delete.deleteCategory(id);
		return response;
	}
}
