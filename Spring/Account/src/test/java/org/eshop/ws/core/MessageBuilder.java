package org.eshop.ws.core;

import org.eshop.account.model.businessLogic.manager.UserManager;
import org.eshop.account.model.businessLogic.manager.impl.UserManagerImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class MessageBuilder {

	public static HttpEntity<String> getHeaderInformation() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("pass", "test");
		return new HttpEntity<String>("bodyEmpty", headers);
	}

	public static HttpEntity<UserManager> getBodyInformation() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		UserManager user = new UserManagerImpl();
		return new HttpEntity<UserManager>(user, headers);
	}

}
