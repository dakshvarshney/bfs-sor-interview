package com.paypal.bfs.test.employeeserv.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RecordNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public RecordNotFoundException(String message) {
        super(message);
    }
}
