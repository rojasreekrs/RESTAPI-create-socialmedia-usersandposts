package com.learnspringboot.rest.webservices.restful_web_services.controller;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learnspringboot.rest.webservices.restful_web_services.Service.UserDaoService;
import com.learnspringboot.rest.webservices.restful_web_services.bean.User;
import com.learnspringboot.rest.webservices.restful_web_services.controller.exception.UserNotFoundException;

import jakarta.validation.Valid;


@RestController
public class UserResource {

	// access service class to send request
	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// request to get all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// get a single user
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveSpecificUser(@PathVariable int id) {
		User user = service.findUser(id);
		if(user==null) { 
			throw new UserNotFoundException("id:" + id); 
		} 
		
		EntityModel<User> entityModel = EntityModel.of(user); 
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}

	// create a user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser= service.createUser(user);
		
		//to display the path of the created user so that retrieval becomes easy
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
	}
}
