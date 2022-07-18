package org.spring.boot.product.controller;

import org.spring.boot.product.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/product")
public class ProductController {


   	private static final String LOCAL_SERVER_PORT = "local.server.port";

   	@Autowired
   	private Environment environment;
 
   	@Autowired
	private RestTemplate restTemplate;
   	
   	@RequestMapping(method = RequestMethod.GET)
   	public ResponseEntity getProduct(){
          	return ResponseEntity.ok("Product Controller, Port:  " + environment.getProperty(LOCAL_SERVER_PORT));
   	}
 
   	
   	@RequestMapping(path="/employee", method = RequestMethod.GET)
	public ResponseEntity getOrderWithProducts() {
   		Employee emp = restTemplate.getForObject("http://employee-service/employees/1", Employee.class);
		return ResponseEntity.ok(emp);

	}
}