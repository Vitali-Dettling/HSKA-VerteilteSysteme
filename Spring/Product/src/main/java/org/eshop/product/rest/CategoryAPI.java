package org.eshop.product.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class CategoryAPI {

	@POST
	@Path("/category")
	@Consumes("application/json")
	@Produces("application/json")
	public Response add(String name) {

		System.err.println("-------------- Post ---------------- " + name);

		return Response.ok().build();
	}

	@GET
	@Path("/category")
	@Consumes("application/json")
	@Produces("application/json")
	public List<String> login() {

		List<String> list = new ArrayList<String>();
		list.add("Cat1");
		list.add("Cat2");
		System.err.println("-------------- Get ---------------- " + list.get(0) + " " + list.get(1));
		return list;
	}

	@DELETE
	@Path("/category/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(@PathParam(value = "id") String id) {

		System.err.println("-------------- Delete ---------------- " + "id:" + id);
		return Response.ok().build();
	}
}
