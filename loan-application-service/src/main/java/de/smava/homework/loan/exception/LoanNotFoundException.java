package de.smava.homework.loan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
