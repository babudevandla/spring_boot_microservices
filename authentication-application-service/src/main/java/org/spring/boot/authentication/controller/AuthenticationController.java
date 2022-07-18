package org.spring.boot.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
 
  private static final String LOCAL_SERVER_PORT = "local.server.port";
  
  @Autowired
  private Environment environment;
 
  public ResponseEntity authenticate(){
	  //Here you can implement your own user and password authentication. This method will return the JWT access token used, which we are going to be using as the JWT authentication for the gateway.
	return ResponseEntity.ok("Authentication Controller, Port: " +    environment.getProperty(LOCAL_SERVER_PORT));
 
  }
}
