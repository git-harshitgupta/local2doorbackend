package com.app.local2door.exception_handler;

import com.app.local2door.custom_excpt.EmailExistException;
import com.app.local2door.custom_excpt.IncorrectPasswordException;
import com.app.local2door.custom_excpt.NumberAlreadyInUseException;
import com.app.local2door.custom_excpt.ProductNotAvailableException;
import com.app.local2door.custom_excpt.SamePasswordException;
import com.app.local2door.dto.ErrorResponse;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import javax.persistence.OptimisticLockException;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException(BadCredentialsException e){
        ErrorResponse resp=new ErrorResponse("Invalid Email and password", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<?> productNotAvilableException(ProductNotAvailableException e){
    	
        ErrorResponse resp=new ErrorResponse("Some product went out of stock", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(OptimisticLockException.class)
    public ResponseEntity<?> handleOptimiticLockingException(OptimisticLockException e){
    	ErrorResponse resp=new ErrorResponse("Transaction failed please try again", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<?> handleIncorrectPasswordException(IncorrectPasswordException e){
    	System.out.println("Insdie eroor");
    	ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(SamePasswordException.class)
    public ResponseEntity<?> handleSamePasswordException(IncorrectPasswordException e){
    	System.out.println("Insdie eroor");
    	ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(NumberAlreadyInUseException.class)
    public ResponseEntity<?> handleNumberAlreadyInUseException(NumberAlreadyInUseException e){
    	ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }
    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<?> handleEmailAlreadyExist(EmailExistException e){
    	ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    }

}
