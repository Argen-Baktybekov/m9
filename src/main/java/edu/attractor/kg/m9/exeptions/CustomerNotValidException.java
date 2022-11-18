package edu.attractor.kg.m9.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotValidException extends RuntimeException{
    public CustomerNotValidException(String message) {
        super(message);
    }
}
