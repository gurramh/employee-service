package com.hans.employeeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    ApplicationRunner configProps(@Value("${spring.application.name}") String appName, @Value("${department.api.base.url}") String departmentUrl) {
        return args -> {
            System.out.println("####### APP_NAME :: " + appName);
            System.out.println("####### DEPARTMENT_URL :: " + departmentUrl);
        };
    }

}
