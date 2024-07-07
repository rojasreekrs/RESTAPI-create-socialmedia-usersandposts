package com.learnspringboot.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public Personv1 getFirstVersion() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecondVersion() {
		return new Personv2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path = "/person", params ="version=1")
	public Personv1 getFirstVersionRequestParam() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params ="version=2")
	public Personv2 getSecondVersionRequestParam() {
		return new Personv2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path = "/person/header", headers ="X-API-Version=1")
	public Personv1 getFirstVersionHeader() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header", headers ="X-API-Version=2")
	public Personv2 getSecondVersionHeader() {
		return new Personv2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path = "/person/accept", produces ="application/vnd.company.app-v1+json")
	public Personv1 getFirstVersionMediatype() {
		return new Personv1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces ="application/vnd.company.app-v2+json")
	public Personv2 getSecondVersionMediatype() {
		return new Personv2(new Name("Bob","Charlie"));
	}
}
