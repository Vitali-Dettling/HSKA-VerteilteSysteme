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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.eshop.product.controller.AddProductAction;
import org.eshop.product.controller.DeleteProductAction;
import org.eshop.product.controller.GetProductAction;
import org.eshop.product.controller.ListAllProductsAction;
import org.eshop.product.controller.SearchAction;
import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class ProductAPI {

	@GET
	@Path("/product/{id}")
	@Produces("application/json")
	public Response getProduct(@PathParam(value = "id") String id) throws JSONException {

		GetProductAction productAction = new GetProductAction();
		Response product = productAction.getProductById(id);
		return product;
	}


	@DELETE
	@Path("/product/{id}")
	@Consumes("application/json")
	@Produces(MediaType.WILDCARD)
	public Response delete(@PathParam(value = "id") String id) {

		DeleteProductAction delete = new DeleteProductAction();
		Response response = delete.deleteProduct(id);
		return response;
	}

	@POST
	@Path("/product")
	@Consumes("application/json")
	@Produces(MediaType.WILDCARD)
	public Response add(String sp) throws JSONException {
		
		AddProductAction update = new AddProductAction();		
		Response response = update.addProduct(sp);
		
		return response;
	}

	@GET
	@Path("/product")
	@Produces("application/json")
	public Response getProductList() throws JSONException {

		ListAllProductsAction productList = new ListAllProductsAction();
		Response response = productList.getProducts();
		return response;
	}
	
	
	@GET
	@Path("/filter")
	@Produces("application/json")
	public Response getFilteredProductList(@HeaderParam(value = "details") String details, 
			@HeaderParam(value = "priceMin") double priceMin, 
			@HeaderParam(value = "priceMax") double priceMax) throws JSONException, Exception {

		SearchAction productList = new SearchAction();
		Response response = productList.execute(details, priceMin, priceMax);
		return response;
	}
	
	
	
	// Is not supported by the original web shop.
//		@PUT
//		@Path("/product/{id}")
//		@Consumes("application/json")
//		@Produces("application/json")
//		public Response update(@PathParam(value = "id") String id, Product product) throws Exception {
	//
	//
//		}
}
