package org.spring.boot.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final String LOCAL_SERVER_PORT = "local.server.port";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment environment;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity getOrder() {
		return ResponseEntity.ok("Order Controller, Port: " + environment.getProperty(LOCAL_SERVER_PORT));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity getOrderWithProducts() {
		// We use the restTemplate to call another service; in this case, the
		// product-service.
		// Remember that we are using the spring.application.name we defined for the
		// product in the
		// application.properties of the product microservice.
		String product = restTemplate.getForObject("http://product-service/product", String.class);
		return ResponseEntity.ok("Order Controller, Port: " + environment.getProperty(LOCAL_SERVER_PORT) + " " + product);

	}
}