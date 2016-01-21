package org.eshop.product;

import org.eshop.product.model.sessionFactory.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
public class ProductApplication {

    public static void main(String[] args) {
    	HibernateUtil.getSessionFactory();
        SpringApplication.run(ProductApplication.class, args);
    }
}
