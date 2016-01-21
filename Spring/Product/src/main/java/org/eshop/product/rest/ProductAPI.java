package org.eshop.product.rest;

import org.codehaus.jettison.json.JSONException;
import org.eshop.product.controller.AddProductAction;
import org.eshop.product.controller.DeleteProductAction;
import org.eshop.product.controller.GetProductAction;
import org.eshop.product.controller.ListAllProductsAction;
import org.eshop.product.controller.SearchAction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class ProductAPI {

	// @GET
	// @Path("/product/{id}")
	// @Produces("application/json")
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getProduct(@PathVariable(value = "id") String id) {

		GetProductAction productAction = new GetProductAction();
		ResponseEntity<String> product = productAction.getProductById(id);
		return product;
	}

	// @DELETE
	// @Path("/product/{id}")
	// @Consumes("application/json")
	// @Produces(MediaType.WILDCARD)
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") String id) {

		DeleteProductAction delete = new DeleteProductAction();
		ResponseEntity<String> response = delete.deleteProduct(id);
	}

	// @POST
	// @Path("/product")
	// @Consumes("application/json")
	// @Produces(MediaType.WILDCARD)
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<String> add(@RequestHeader("sp") String sp) {

		AddProductAction update = new AddProductAction();
		ResponseEntity<String> response = update.addProduct(sp);

		return response;
	}

	// @GET
	// @Path("/product")
	// @Produces("application/json")
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<String> getProductList() throws JSONException {

		ListAllProductsAction productList = new ListAllProductsAction();
		ResponseEntity<String> response = productList.getProducts();
		return response;
	}

	// @GET
	// @Path("/filter")
	// @Produces("application/json")
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<String> getFilteredProductList(@RequestHeader("details") String details,
			@RequestHeader("priceMin") String priceMin, @RequestHeader("priceMax") String priceMax) {

		SearchAction productList = new SearchAction();
		ResponseEntity<String> response = productList.execute(details, Double.valueOf(priceMin), Double.valueOf(priceMax));
		return response;
	}

	// Is not supported by the original web shop.
	// @PUT
	// @Path("/product/{id}")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response update(@PathParam(value = "id") String id, Product
	// product) throws Exception {
	//
	//
	// }
}