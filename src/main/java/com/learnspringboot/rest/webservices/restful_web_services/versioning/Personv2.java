package com.learnspringboot.rest.webservices.restful_web_services.versioning;

public class Personv2 {
	private Name name;

	public Personv2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Personv2 [name=" + name + "]";
	}
	
}
