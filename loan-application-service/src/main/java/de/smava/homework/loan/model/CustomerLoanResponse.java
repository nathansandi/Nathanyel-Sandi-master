package de.smava.homework.loan.model;

import java.util.ArrayList;
import lombok.Value;
@Value
public class CustomerLoanResponse {
	private CustomerResponse customer;
	private ArrayList<LoanSearchResponse> loan;

	public CustomerResponse getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerResponse customer) {
		this.customer = customer;
	}
	public ArrayList<LoanSearchResponse> getLoan() {
		return loan;
	}
	public void setLoan(ArrayList<LoanSearchResponse> loan) {
		this.loan = loan;
	}
	public CustomerLoanResponse() {		// TODO Auto-generated constructor stub
	
	}

}
