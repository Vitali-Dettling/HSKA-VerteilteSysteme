package org.eshop.product.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eshop.product.controller.AddProductAction;
import org.eshop.product.controller.DeleteProductAction;
import org.eshop.product.controller.GetProductAction;
import org.eshop.product.controller.ListAllProductsAction;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class ProductAPI {

	@GET
	@Path("/product/{id}")
	@Produces("application/json")
	public Response getProduct(@PathParam(value = "id") String id) {

		GetProductAction productAction = new GetProductAction();
		Response product = productAction.getProductById(id);
		return product;
	}
// Is not supported by the original web shop.
//	@PUT
//	@Path("/product/{id}")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public Response update(@PathParam(value = "id") String id, Product product) throws Exception {
//
//
//	}

	@DELETE
	@Path("/product/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(@PathParam(value = "id") String id) {

		DeleteProductAction delete = new DeleteProductAction();
		Response response = delete.deleteProduct(id);
		return response;
	}

	@POST
	@Path("/product")
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Product product) {
		
		AddProductAction update = new AddProductAction();		
		Response response = update.addProduct(product);
		return response;
	}

	@GET
	@Path("/product")
	@Produces("application/json")
	public Response getProductList() {

		ListAllProductsAction productList = new ListAllProductsAction();
		Response response = productList.getProducts();
		return response;
	}
}
