package com.learnspringboot.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String name;
	private String details;
	
	public ErrorDetails(LocalDateTime timestamp, String name, String details) {
		super();
		this.timestamp = timestamp;
		this.name = name;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getName() {
		return name;
	}

	public String getDetails() {
		return details;
	}
	
}
