package org.eshop.proxy;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ProxyAPI {

    @Autowired
    private RestTemplate restTemplate;
    
//    @HystrixCommand(commandProperties = {
//    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public Response getProductList() {
    	
    	System.out.println("Works ^^ ");
    	
    	Response result = restTemplate.getForObject("http://Product/getProductList", Response.class);
    	
    	System.out.println("Works ^^ " + result.getStatus());
    	
        return Response.ok().build();
    }
	
	

}
