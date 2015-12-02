package org.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
    
    
//  @Bean
//  public ServletRegistrationBean jerseyServlet() {
//      ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/rest/*");
//      // our rest resources will be available in the path /rest/*
//      registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//      return registration;
//  }
}
