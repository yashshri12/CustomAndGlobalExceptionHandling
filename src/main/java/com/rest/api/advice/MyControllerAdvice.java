package com.rest.api.advice;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.api.exception.EmptyInput;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchException(NoSuchElementException e){
		return new ResponseEntity<String>("No value present in Database",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEnitityNotFound(EntityNotFoundException e){
		return new ResponseEntity<String>("Employee not present in Database",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyInput.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInput e){
		return new ResponseEntity<String>("Null value",HttpStatus.BAD_REQUEST);
	}
  @Override
protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatus status, WebRequest request) {
	// TODO Auto-generated method stub
	  return new ResponseEntity<Object>("Please Change Http method",HttpStatus.BAD_REQUEST);
}
}
