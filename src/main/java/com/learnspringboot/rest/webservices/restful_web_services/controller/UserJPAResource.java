package com.learnspringboot.rest.webservices.restful_web_services.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.learnspringboot.rest.webservices.restful_web_services.bean.Post;
import com.learnspringboot.rest.webservices.restful_web_services.bean.User;
import com.learnspringboot.rest.webservices.restful_web_services.controller.exception.UserNotFoundException;
import com.learnspringboot.rest.webservices.restful_web_services.repository.PostRepository;
import com.learnspringboot.rest.webservices.restful_web_services.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	// access service class to send request

	private UserRepository repository;

	private PostRepository postRepository;

	public UserJPAResource(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

	// request to get all users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	// get a single user
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveSpecificUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));

		return entityModel;
	}

	// create a user
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

		User savedUser = repository.save(user);

		// to display the path of the created user so that retrieval becomes easy
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		return user.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}

		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
