package org.eshop.REST;

import org.eshop.core.AccountAPI;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping(value = "/account/{user}", method = RequestMethod.GET)
	public String loginAccount(@PathVariable String user) {
		return new AccountAPI(user).getUser();
	}

	@RequestMapping(value = "/account/{user}", method = RequestMethod.DELETE)
	public String deleteAccount(@PathVariable String user) {
		return new AccountAPI(user).deleteUser();
	}

	@RequestMapping(value = "/account/{user}", method = RequestMethod.PUT)
	public String updateAccount(@PathVariable String user) {
		return new AccountAPI(user).updateUser();
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String createAccount(@PathVariable String user) {
		return new AccountAPI(user).createUser();
	}
}
