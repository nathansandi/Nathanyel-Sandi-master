package de.smava.homework.customer.model;

import lombok.Value;

@Value
public class CustomerResponse {
	
	private String id;
	
	public CustomerResponse() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
