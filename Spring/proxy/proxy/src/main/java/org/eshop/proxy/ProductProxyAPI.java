package org.eshop.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductProxyAPI {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getProduct(@PathVariable(value = "id") String id) {

		ResponseEntity<String> result = restTemplate.getForEntity("http://Product/product/" + id, String.class, id);

		return result;
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable(value = "id") String id) {

		restTemplate.delete("http://Product/product/" + id);
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<String> addProduct(@RequestHeader("sp") String sp) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("sp", sp);

		HttpEntity entity = new HttpEntity<>("", headers);

		ResponseEntity<String> result = restTemplate.exchange("http://Product/product/", HttpMethod.POST, entity,
				String.class);

		return result;
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ResponseEntity<String> getProductList() {

		ResponseEntity<String> result = restTemplate.getForEntity("http://Product/product/", String.class);

		return result;
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<String> getFilteredProductList(@RequestHeader("details") String details,
			@RequestHeader("priceMin") String priceMin, @RequestHeader("priceMax") String priceMax) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("details", details);
		headers.set("priceMin", priceMin);
		headers.set("priceMax", priceMax);

		HttpEntity entity = new HttpEntity<>("", headers);

		ResponseEntity<String> result = restTemplate.exchange("http://Product/filter/", HttpMethod.GET, entity,
				String.class);

		return result;
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ResponseEntity<String> addCategory(@RequestHeader("name") String name) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("name", name);

		HttpEntity entity = new HttpEntity<>("", headers);

		ResponseEntity<String> result = restTemplate.exchange("http://Product/category/", HttpMethod.POST, entity,
				String.class);

		return result;
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ResponseEntity<String> getCategories() {

		ResponseEntity<String> result = restTemplate.getForEntity("http://Product/category/", String.class);

		return result;
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable(value = "id") String id) {

		restTemplate.delete("http://Product/category/" + id);
	}

}
