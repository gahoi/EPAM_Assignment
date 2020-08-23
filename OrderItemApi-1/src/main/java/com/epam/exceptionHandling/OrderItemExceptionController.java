package com.epam.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.epam.domain.ErrorObject;

import feign.FeignException;

@ControllerAdvice
public class OrderItemExceptionController {
	
	@ExceptionHandler(value = FeignException.class)
	public ResponseEntity<Object> orderItemNotFound(FeignException e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> methodArguementTypeMismatch(MethodArgumentTypeMismatchException e){
		ErrorObject err = new ErrorObject();
		err.setErrorId("102");
		err.setErrorMessgae(e.getMessage());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = OrderItemNotFound.class)
	public ResponseEntity<ErrorObject> OrderItemNotFound(OrderItemNotFound e){
		ErrorObject err = new ErrorObject();
		err.setErrorId("103");
		err.setErrorMessgae(e.getMessage());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.BAD_REQUEST);
	}


}
