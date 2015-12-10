package org.eshop.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eshop.product.ProductApplication;
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

import com.mongodb.util.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class CategoryAPITest {

	private RestTemplate restTemplate = new TestRestTemplate();
	private final String url = "http://localhost:9000/category";
	private final String testIdPath = "/idTest";

	@Test
	public void testAddProductPOST() {

		HttpEntity<String> entity = MessageBuilder.getBodyInformation("TestCat");

		ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());
	}

	@Test
	@SuppressWarnings("rawtypes")
	public void testListCategoriesGET() {

		ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);

		assertNotNull(entity);
		assertTrue(entity.getStatusCode().is2xxSuccessful());
		assertEquals(entity.getBody().get(0), "Cat1");
	}

	@Test
	public void testListJsonGET() {

		ResponseEntity<List> entity = restTemplate.getForEntity(url, List.class);

		String jsonTest = JSON.serialize(entity.getBody());

		assertNotNull(jsonTest);
	}

	@Test
	public void testCategoryDELETE() {

		HttpEntity<String> entity = new HttpEntity<String>(null, null);

		ResponseEntity<String> entitytests = restTemplate.exchange(url + testIdPath, HttpMethod.DELETE, entity,
				String.class);

		assertNotNull(entitytests);
		assertTrue(entitytests.getStatusCode().is2xxSuccessful());
	}

}
