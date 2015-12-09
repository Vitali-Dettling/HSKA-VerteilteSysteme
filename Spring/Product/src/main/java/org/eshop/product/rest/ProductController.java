package org.eshop.product.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eshop.ws.core.Product;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class ProductController {

	@GET
	@Path("/product/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Product getProduct(@PathParam(value = "id") String id) {

		Product product = new Product(id, 42, "testCategory");

		System.err.println("-------------- Delete ---------------- " + "product: " + product.getName());
		return product;
	}

	@PUT
	@Path("/product/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(@PathParam(value = "id") String id, Product product) {

		System.err.println("-------------- Post ---------------- " + "id: " + id + "product: " + product.getName());

		return Response.ok().build();
	}

	@DELETE
	@Path("/product/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(@PathParam(value = "id") String id) {

		System.err.println("-------------- Delete ---------------- " + "id: " + id);
		return Response.ok().build();
	}

	@POST
	@Path("/product")
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(Product product) {

		System.err.println("-------------- Delete ---------------- " + "product: " + product.getName());
		return Response.ok().build();
	}

	@GET
	@Path("/product")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Product> getProductList() {

		Product product = new Product("ProductList", 42, "testCategory");

		System.err.println("-------------- Delete ---------------- " + "product: " + product.getName());
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		return productList;//Arrays.asList(product);
	}
}
