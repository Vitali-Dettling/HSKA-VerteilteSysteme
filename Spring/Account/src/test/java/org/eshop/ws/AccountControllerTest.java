package org.eshop.ws;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.catalina.WebResource;
import org.eshop.AccountApplication;
import org.eshop.core.UserDAO;
import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.message.internal.HeaderUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class AccountControllerTest {

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testLoginPathVariableGET() {
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:9000/account/test", String.class);

		assertNotNull(entity);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testLoginPasswordInHeaderGET() {

		UserDAO user = new UserDAO();
		user.setUser("user");
		user.setPass("pass");

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("pass", "test");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> entitytests = restTemplate.exchange("http://localhost:9000/account/test", HttpMethod.GET, entity, String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testCreateUserPOST() {

		UserDAO user = new UserDAO();
		user.setUser("testUser");
		user.setPass("testPass");

		ResponseEntity<String> entitytess = restTemplate.postForEntity("http://localhost:9000/account", user, String.class);

		assertNotNull(entitytess);
		assertTrue(entitytess.getStatusCode().is2xxSuccessful());
	}


}
