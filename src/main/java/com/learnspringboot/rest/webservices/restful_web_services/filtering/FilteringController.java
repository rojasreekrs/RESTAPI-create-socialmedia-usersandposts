package com.learnspringboot.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public ExampleBean filtering() {
		return new ExampleBean("val1","val2","val3");
	}
	
	@GetMapping("/filtering-list")
	public List<ExampleBean> filteringList() {
		return Arrays.asList(new ExampleBean("val1","val2","val3"),
				new ExampleBean("val5","val6","val7"));
	}
}
