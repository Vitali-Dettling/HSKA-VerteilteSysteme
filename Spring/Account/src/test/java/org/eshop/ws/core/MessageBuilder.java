package org.eshop.ws.core;

import org.eshop.ws.core.User;
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

	public static HttpEntity<User> getBodyInformation() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		User user = new User("testUser", "testUser", "testUser", "testUser", true);
		return new HttpEntity<User>(user, headers);
	}

}
