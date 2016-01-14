package org.eshop.account.rest;

import javax.ws.rs.core.Response;

import org.eshop.account.controller.LoginAction;
import org.eshop.account.controller.RegisterAction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Component
//@Path("/")
public class AccountAPI {

//	@GET
//	@Path("/account/{user}")
//	@Consumes("application/json")
//	@Produces("application/json")
//	@RequestMapping(value = "/account/{user}", method = RequestMethod.GET)
	@RequestMapping(value = "/account/{user}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> login(@PathVariable(value = "user") String user, @RequestHeader("pass") String pass) {

		LoginAction login = new LoginAction();

		 ResponseEntity<Boolean> status = login.execute(user, pass);
		
		return status;
	}


//	@POST
//	@Path("/account")
//	@Consumes("application/json")
//	@Produces("application/json")
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestHeader("user") String user, @RequestHeader("pass") String pass) throws Exception {

		RegisterAction register = new RegisterAction();

		ResponseEntity<String> status = register.execute(user, pass);

		return status;
	}

}
