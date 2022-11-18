package edu.attractor.kg.m9.utils;

import edu.attractor.kg.m9.controllers.CustomerControllers;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {CustomerControllers.class})
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})

    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException e){

        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler(value = {CustomerNotValidException.class})
    public ResponseEntity<String> customerNotValidException(CustomerNotValidException e){

        return ResponseEntity.ok(e.getMessage());
    }


}
