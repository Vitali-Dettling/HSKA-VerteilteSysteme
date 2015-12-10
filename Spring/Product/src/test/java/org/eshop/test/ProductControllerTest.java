package org.eshop.test;

import static org.junit.Assert.*;

import org.eshop.product.model.database.dataobjects.Category;
import org.eshop.product.model.database.dataobjects.Product;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ProductControllerTest {

	private RestTemplate restTemplate = new TestRestTemplate();
	private final String url = "http://localhost:8080/product";
	private final String testIdPath = "/idTest";
	
	
	@Test
	public void testAdd() {
		
//		HttpEntity<Product> entity = MessageBuilder.getBodyInformation(product);
//
//		//ResponseEntity<Boolean> entity = restTemplate.getForEntity(url + testPath, Boolean.class);
//		ResponseEntity<String> result = restTemplate.getForEntity(url, HttpMethod.POST, String.class);
//
//		assertNotNull(result);
//		assertTrue(result.getStatusCode().is2xxSuccessful());
		
	}
	
	@Test
	public void testGetProduct() {
		
	}

	@Test
	public void testUpdate() {
		
		Product product = new Product();
		product.setId(42);
		product.setName("nameTest");
		product.setPrice(123);
		product.setCategory(new Category("categoryTest"));
		product.setDetails("detailsTest");
		HttpEntity<Product> entity = MessageBuilder.getBodyInformation(product);

		ResponseEntity<String> result = restTemplate.exchange(url + testIdPath, HttpMethod.PUT, entity, String.class);

		assertNotNull(result);
		assertTrue(result.getStatusCode().is2xxSuccessful());

	}

	@Test
	public void testDelete() {
		
		
		
		
	}

	@Test
	public void testGetProductList() {
		
	}

}
