package edu.attractor.kg.m9.utils;

import edu.attractor.kg.m9.controllers.CustomerControllers;
import edu.attractor.kg.m9.entities.Customer;
import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.exeptions.CustomerNotValidException;
import edu.attractor.kg.m9.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(basePackageClasses = {CustomerControllers.class})
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String resourceNotFoundException(ResourceNotFoundException e){

        return e.getMessage();
    }

    @ExceptionHandler(value = {CustomerNotValidException.class})
//    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> customerNotValidException(CustomerNotValidException e){

        return ResponseEntity.ok(e.getMessage());
    }


}
