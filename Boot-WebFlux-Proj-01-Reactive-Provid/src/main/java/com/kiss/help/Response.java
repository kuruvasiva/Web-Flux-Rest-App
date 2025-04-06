package com.kiss.help;

import com.kiss.model.Phone;

import lombok.Data;

@Data
public class Response {
	
	/*private Phone phone;
	private String message;
	
	// Constructor for successful phone retrieval
	public Response(Phone phone) {
	    this.phone = phone;
	}
	
	// Constructor for error message
	public Response(String message) {
	    this.message = message;
	}*/
	
	
	private Object result;
	
	
	public Response(Phone phone) {
		
		result = phone;
	}
	public Response(String msg) {
		
		result = msg;
	}
	
	
}
