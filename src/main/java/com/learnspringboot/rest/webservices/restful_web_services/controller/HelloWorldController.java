package com.learnspringboot.rest.webservices.restful_web_services.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.rest.webservices.restful_web_services.bean.HelloWorldBean;

@RestController
//@RequestMapping
public class HelloWorldController {
	//@RequestMapping(method=RequestMethod.GET,path="/helloworld")
	
	private MessageSource msg;
	
	public HelloWorldController(MessageSource msg) {
		this.msg = msg;
	}
	@GetMapping("/helloworld")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping("/helloworldbean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/helloworld/pathvariable/{name}")
	public HelloWorldBean helloworldPathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}
	
	@GetMapping("/helloworld-international")
	public String helloworldInternational() {
		
		Locale locale = LocaleContextHolder.getLocale();
		return msg.getMessage("good.morning.message", null, "Good Morning", locale);
		
		//return "Hello World";
	}
}
