package com.learnspringboot.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExampleBean {
	private String value1;
	// filtering val2
	@JsonIgnore
	private String value2;
	private String value3;

	public ExampleBean(String value1, String value2, String value3) {
		super();
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}

	public String getValue1() {
		return value1;
	}

	public String getValue2() {
		return value2;
	}

	public String getValue3() {
		return value3;
	}

	@Override
	public String toString() {
		return "ExampleBean [value1=" + value1 + ", value2=" + value2 + ", value3=" + value3 + "]";
	}
}
