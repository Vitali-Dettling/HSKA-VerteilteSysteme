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

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.eshop.account.model.database.dataobjects.Role;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.google.inject.spi.Message;

import org.eshop.account.model.database.dataobjects.User;

@Component
@Path("/")
public class AccountController {

	@GET
	@Path("/account/{user}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response login(@PathParam(value = "user") String user, @HeaderParam("pass") String pass) throws Exception {

		LoginAction login = new LoginAction();

		Response status = login.execute(user, pass);
		
		return status;
	}

//	Is not supported by the original web shop.
//	@PUT
//	@Path("/account/{user}")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public Response update(@PathParam(value = "user") String user, @HeaderParam("pass") String pass,  @HeaderParam("newPass") String newPass) throws Exception {
//
//		return Response.noContent().status(stateCode).build();
//	}

//	Is not supported by the original web shop.
//	@DELETE
//	@Path("/account/{user}")
//	@Consumes("application/json")
//	@Produces("application/json")
//	public Response delete(@PathParam(value = "user") String user, @HeaderParam("pass") String pass) {
//
//		System.err.println("-------------- Delete ---------------- " + "user:" + user + " pass: " + pass);
//		return Response.ok().build();
//	}

	@POST
	@Path("/account")
	@Consumes("application/json")
	@Produces("application/json")
	public Response create(@HeaderParam("user") String user, @HeaderParam("pass") String pass) throws Exception {

		RegisterAction register = new RegisterAction();

		Response status = register.execute(user, pass);

		return status;
	}

}
