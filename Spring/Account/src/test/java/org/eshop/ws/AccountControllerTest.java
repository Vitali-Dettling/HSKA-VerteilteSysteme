package org.eshop.ws;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.eshop.AccountApplication;
import org.eshop.ws.core.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class AccountControllerTest {

	private RestTemplate restTemplate = new TestRestTemplate();
	private final String url = "http://localhost:9000/account";
	private final String testPath = "/test";

	@Test
	public void testLoginPathVariableGET() {
		ResponseEntity<String> entity = restTemplate.getForEntity(url + testPath, String.class);

		assertNotNull(entity);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testLoginPasswordInHeaderGET() {

		HttpEntity<String> entity = MessageBuilder.getHeaderInformation();
		ResponseEntity<String> entitytests = restTemplate.exchange(url + testPath, HttpMethod.GET, entity,
				String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testUpdateWithHeaderPUT() {

		HttpEntity<String> entity = MessageBuilder.getHeaderInformation();

		ResponseEntity<String> entitytests = restTemplate.exchange(url + testPath, HttpMethod.PUT, entity,
				String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testDeleteWithHeaderDELETE() {

		HttpEntity<String> entity = MessageBuilder.getHeaderInformation();

		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		ResponseEntity<String> entitytests = restTemplate.exchange(url + testPath, HttpMethod.DELETE, entity,
				String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testCreateUserPOST() {

		HttpEntity<User> entity = MessageBuilder.getBodyInformation();

		ResponseEntity<User> entitytess = restTemplate.exchange(url, HttpMethod.POST, entity, User.class);

		assertNotNull(entitytess);
		assertTrue(entitytess.getStatusCode().is2xxSuccessful());
		assertEquals(entitytess.getBody().getPassword(), "testUser");
		assertTrue(entitytess.getBody().getRole());
	}
}
