package org.spring.boot.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class EmployeeApplicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplicationServiceApplication.class, args);
	}

}
