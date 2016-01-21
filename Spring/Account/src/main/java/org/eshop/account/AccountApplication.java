package org.eshop.account;

import org.eshop.account.model.sessionFactory.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableDiscoveryClient
public class AccountApplication {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		SpringApplication.run(AccountApplication.class, args);
	}
}
