package org.eshop.test;

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

	public static <T> HttpEntity<T> getBodyInformation(T body) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return new HttpEntity<T>(body, headers);
	}

}
