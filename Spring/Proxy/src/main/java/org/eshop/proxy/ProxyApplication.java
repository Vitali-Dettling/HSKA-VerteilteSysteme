package org.eshop.proxy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
//@EnableCircuitBreaker
//@EnableHystrixDashboard
@RibbonClient("user-proxy")
@SpringBootApplication
@ComponentScan
public class ProxyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
