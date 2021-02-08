package de.smava.homework.loan.model;

import lombok.Value;

@Value
public class LoanResponse {
	
	private String id;

	
	public LoanResponse() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


}
