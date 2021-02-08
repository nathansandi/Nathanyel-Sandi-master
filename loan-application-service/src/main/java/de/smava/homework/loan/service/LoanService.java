package de.smava.homework.loan.service;
import de.smava.homework.loan.config.LoanServiceImpl;
import de.smava.homework.loan.entity.CustomerEntity;
import de.smava.homework.loan.entity.LoanEntity;
import de.smava.homework.loan.exception.CustomerNotFoundException;
import de.smava.homework.loan.model.CustomerLoanResponse;
import de.smava.homework.loan.model.LoanDTO;
import de.smava.homework.loan.model.LoanResponse;
import de.smava.homework.loan.repository.CustomerRepository;
import de.smava.homework.loan.repository.LoanRepository;
import de.smava.homework.loan.model.LoanStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanService {
	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private LoanServiceImpl loanServiceImpl;
	
	
	final static Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	@Transactional
    public LoanResponse create(LoanDTO loanDTO) {
			LoanResponse response = new LoanResponse();
			logger.info("Get customer with id id: {}",loanDTO.getCustomerId());
			Optional<CustomerEntity> customerOpt = customerRepository.findById(loanDTO.getCustomerId());
			if (!customerOpt.isPresent()) {
	            throw new CustomerNotFoundException();
	        }
	        loanDTO.setId(UUID.randomUUID().toString());
	        loanDTO.setStatus(LoanStatus.CREATED);
	        LoanEntity loan = new LoanEntity();
	        BeanUtils.copyProperties(loanDTO,loan);
	        loan.setCustomer(customerOpt.get());
	        logger.info("Going save loan: {}",loan.toString());
	        loanRepository.save(loan);
	        logger.info("Saved loan with id: {}",loan.getId());
	        response.setId(loan.getId());
	        return response;
    }
    //Get Loan by customer ID
    public CustomerLoanResponse get(String id) {
    	CustomerLoanResponse customerResponse= loanServiceImpl.loadLoanByCustomer(id); 
        return customerResponse;
    }
    
}
