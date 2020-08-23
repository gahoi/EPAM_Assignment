package com.epam.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.epam.domain.ErrorObject;

@ControllerAdvice
public class OrderExceptionController {
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ErrorObject> orderNotFoundException(OrderNotFoundException e){
		ErrorObject err = new ErrorObject();
		err.setErrorId("101");
		err.setErrorMessgae(e.getMessage());
		
		ResponseEntity<ErrorObject> re = new ResponseEntity<ErrorObject>(err ,HttpStatus.BAD_REQUEST);
		return re;
	}
	
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> methodArguementTypeMismatch(MethodArgumentTypeMismatchException e){
		ErrorObject err = new ErrorObject();
		err.setErrorId("102");
		err.setErrorMessgae(e.getMessage());
		return new ResponseEntity<ErrorObject>(err,HttpStatus.BAD_REQUEST);
	}

}
