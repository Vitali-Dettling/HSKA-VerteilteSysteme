package org.eshop.ws.core;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eshop.AccountApplication;
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
		ResponseEntity<Boolean> entity = restTemplate.getForEntity(url + testPath, Boolean.class);

		assertNotNull(entity);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
		assertTrue(entity.getBody());
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

		ResponseEntity<String> entitytests = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}
}
