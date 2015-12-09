package org.eshop.ws.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eshop.ProductApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mongodb.util.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class ProductControllerTest {

	private RestTemplate restTemplate = new TestRestTemplate();
	private final String url = "http://localhost:9000/product";
	private final String testIdPath = "/idTest";

	@Test
	public void testReturnProductGET() {

		ResponseEntity<String> result = restTemplate.getForEntity(url + testIdPath, String.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testUpdateProductPUT() {

		Product product = new Product("TestProductPUT", 42, "TestCategoryPUT");
		HttpEntity<Product> entity = MessageBuilder.getBodyInformation(product);

		ResponseEntity<String> result = restTemplate.exchange(url + testIdPath, HttpMethod.PUT, entity, String.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testDeleteProductDELETE() {

		HttpEntity<String> entity = new HttpEntity<String>(null, null);

		ResponseEntity<String> result = restTemplate.exchange(url + testIdPath, HttpMethod.DELETE, entity,
				String.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void testAddNewProductPOST() {

		Product product = new Product("testProduct", 42, "testCategory");
		HttpEntity<Product> entity = MessageBuilder.getBodyInformation(product);

		ResponseEntity<String> entitytests = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

	@Test
	@SuppressWarnings({ "rawtypes" })
	public void testListProductsGET() throws JsonParseException, JsonMappingException, IOException {

		ResponseEntity<List> result = restTemplate.getForEntity(url, List.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());
		assertFalse(result.getBody().isEmpty());
		//This will fail as soon as a real implementation is installed. 
		assertEquals(result.getBody().get(0).toString(),
				"{id=0, name=ProductList, price=42.0, category=testCategory, details=null}");
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void testListJsonGET() {

		ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);

		String jsonTest = JSON.serialize(entity.getBody());

		assertNotNull(jsonTest);
	}

}
