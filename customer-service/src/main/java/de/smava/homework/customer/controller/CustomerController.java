package de.smava.homework.customer.controller;

import de.smava.homework.customer.model.CustomerDTO;
import de.smava.homework.customer.model.CustomerResponse;
import de.smava.homework.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	


    @GetMapping("/api/customer/{id}")
    public ResponseEntity<CustomerDTO> read(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(customerService.get(id));
    }
    @PostMapping("/customers")
    public ResponseEntity<CustomerResponse> register(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.ok().body(customerService.create(customerDTO));
    }
}
