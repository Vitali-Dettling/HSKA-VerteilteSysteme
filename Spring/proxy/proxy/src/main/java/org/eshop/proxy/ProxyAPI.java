package org.eshop.proxy;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
public class ProxyAPI {

	private final Map<String, String> userCache = new LinkedHashMap<String, String>();
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getUserCache", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	@RequestMapping(value = "/account/{user}", method = RequestMethod.GET)
    public ResponseEntity<Boolean> loginAccount(@PathVariable(value = "user") String user, @RequestHeader("pass") String pass) {
    	
 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("pass", pass);
		
		HttpEntity entity = new HttpEntity<>("", headers);
		
		
    	ResponseEntity<Boolean> result = restTemplate.exchange("http://Account/account/" + user, HttpMethod.GET, entity, Boolean.class);
    
    	if (result.getBody() == true)
    		userCache.putIfAbsent(user, pass);
    	

        return result;
    }
	
	
	@HystrixCommand(fallbackMethod = "createAccountFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
	@RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<String> createAccount(@RequestHeader(value = "user") String user, @RequestHeader("pass") String pass) {
    	
 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("user", user);
		headers.set("pass", pass);
		
		HttpEntity entity = new HttpEntity<>("", headers);
		
    	ResponseEntity<String> result = restTemplate.exchange("http://Account/account", HttpMethod.POST, entity, String.class);

        return result;
    }
	
	@HystrixCommand
	public ResponseEntity<String> getUserCache(String user, String pass) {

		if(userCache.get(user) != null && userCache.get(user).equals(pass))		
			return new ResponseEntity<String>("true", HttpStatus.OK);
		else
			return new ResponseEntity<String>("false", HttpStatus.UNAUTHORIZED);
	}
	
	@HystrixCommand
	public ResponseEntity<String> createAccountFallback(String user, String pass) {

		return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
	}

}
