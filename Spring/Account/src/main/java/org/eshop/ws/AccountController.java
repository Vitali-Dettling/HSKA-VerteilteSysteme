package org.eshop.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eshop.core.AccountImpl;
import org.eshop.core.UserDAO;
import org.springframework.stereotype.Component;


@Component
@Path("/")
public class AccountController {

	@GET
	@Path("/account/{user}")
	@Consumes(MediaType.TEXT_PLAIN)
	public String login(@PathParam(value="user") String user, @HeaderParam("pass") String pass) {
		
		System.err.println("-------------- Get ---------------- " + "user:" + user + " pass: " + pass);
		return "200";
	}	
	
	
	
	@POST
	@Path("/account")
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(UserDAO user) {
		
		System.err.println("-------------- Post ---------------- " + user.getUser());
		
		return "200";
	}
	

	
	
}
