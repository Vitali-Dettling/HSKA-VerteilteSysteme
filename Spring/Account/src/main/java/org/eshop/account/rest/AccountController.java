package org.eshop.account.rest;

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

import org.eshop.ws.core.User;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class AccountController {

	@GET
	@Path("/account/{user}")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean login(@PathParam(value = "user") String user, @HeaderParam("pass") String pass) {

		System.err.println("-------------- Get ---------------- " + "user:" + user + " pass: " + pass);
		return true;
	}

	@PUT
	@Path("/account/{user}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response update(@PathParam(value = "user") String user, @HeaderParam("pass") String pass) {

		System.err.println("-------------- Put ---------------- " + "user:" + user + " pass: " + pass);
		return Response.ok().build();
	}

	@DELETE
	@Path("/account/{user}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response delete(@PathParam(value = "user") String user, @HeaderParam("pass") String pass) {

		System.err.println("-------------- Delete ---------------- " + "user:" + user + " pass: " + pass);
		return Response.ok().build();
	}

	@POST
	@Path("/account")
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(User user) {

		System.err.println("-------------- Post ---------------- " + user.getFirstname() + " pass: " + user.getPassword());

		return Response.ok().build();
	}

}
