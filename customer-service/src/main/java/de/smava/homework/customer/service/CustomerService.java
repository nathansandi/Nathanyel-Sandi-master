package de.smava.homework.customer.service;

import de.smava.homework.customer.entity.CustomerEntity;
import de.smava.homework.customer.entity.UserEntity;
import de.smava.homework.customer.exception.UserNotFoundException;
import de.smava.homework.customer.model.CustomerDTO;

import de.smava.homework.customer.model.CustomerResponse;
import de.smava.homework.customer.repository.CustomerRepository;
import de.smava.homework.customer.repository.UserRepository;
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
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
	private UserRepository userRepository;
	
	final static Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
	@Transactional
    public CustomerResponse create(CustomerDTO customerDTO) {
			CustomerResponse response = new CustomerResponse();
			logger.info("Get user with id id: {}",customerDTO.getUserId());
			Optional<UserEntity> userOpt = userRepository.findById(customerDTO.getUserId());
			if (!userOpt.isPresent()) {
	            throw new UserNotFoundException();
	        }
			customerDTO.setId(UUID.randomUUID().toString());
	        CustomerEntity customer = new CustomerEntity();
	        BeanUtils.copyProperties(customerDTO,customer);
	        customer.setUser(userOpt.get());
	        logger.info("Going save loan: {}",customer.toString());
	        customerRepository.save(customer);
	        logger.info("Saved loan with id: {}",customer.getId());
	        response.setId(customer.getId());
	        return response;
    }
    //Get Loan by customer ID
    public CustomerDTO get(String id) {
    	CustomerEntity customer= customerRepository.findById(id).get(); 
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return customerDTO;
    }
    
}
