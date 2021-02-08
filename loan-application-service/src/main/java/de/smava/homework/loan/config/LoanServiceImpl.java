package de.smava.homework.loan.config;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.smava.homework.loan.entity.CustomerEntity;
import de.smava.homework.loan.entity.LoanEntity;
import de.smava.homework.loan.exception.CustomerNotFoundException;
import de.smava.homework.loan.model.CustomerLoanResponse;
import de.smava.homework.loan.model.CustomerResponse;
import de.smava.homework.loan.model.LoanSearchResponse;
import de.smava.homework.loan.repository.CustomerRepository;
import de.smava.homework.loan.repository.LoanRepository;

@Service
public class LoanServiceImpl{
	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
    public CustomerLoanResponse loadLoanByCustomer(String id) throws CustomerNotFoundException {
        Optional<CustomerEntity> optionalCustomer= customerRepository.findById(id);
        CustomerLoanResponse response = new CustomerLoanResponse();
        if (!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException();
        }
        List<LoanEntity> loans = loanRepository.findByCustomerId(id);
        CustomerResponse customerResp = new CustomerResponse();
        
        //Response Customer
        customerResp.setId(optionalCustomer.get().getId());
        customerResp.setFirstName(optionalCustomer.get().getFirstName());
        customerResp.setLastName(optionalCustomer.get().getLastName());
        
        //Response Loans
        ArrayList<LoanSearchResponse> loanResp = new ArrayList<LoanSearchResponse>();
        for(LoanEntity current: loans) {
        	LoanSearchResponse loanToSave = new LoanSearchResponse();
        	loanToSave.setId(current.getId());
        	loanToSave.setAmount(current.getAmount());
        	loanToSave.setDuration(current.getDuration());
        	loanToSave.setStatus(current.getStatus());
        	loanResp.add(loanToSave);
        }
        response.setCustomer(customerResp);
        response.setLoan(loanResp);        
    	return response;
    }

}
