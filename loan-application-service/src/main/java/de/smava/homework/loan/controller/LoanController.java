package de.smava.homework.loan.controller;

import de.smava.homework.loan.model.CustomerLoanResponse;
import de.smava.homework.loan.model.LoanDTO;
import de.smava.homework.loan.model.LoanResponse;
import de.smava.homework.loan.service.LoanService;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loanapplications")
public class LoanController {
	@Autowired
    private LoanService loanService;
	


    @GetMapping("/{id}")
    public ResponseEntity<CustomerLoanResponse> read(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(loanService.get(id));
    }
    @PostMapping
    public ResponseEntity<LoanResponse> register(@RequestBody @Valid LoanDTO loanDTO) {
        return ResponseEntity.ok().body(loanService.create(loanDTO));
    }
}
