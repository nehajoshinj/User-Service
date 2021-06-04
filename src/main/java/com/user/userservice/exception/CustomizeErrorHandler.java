package com.user.userservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeErrorHandler extends ResponseEntityExceptionHandler {

	/**
	 * Response structure :-
	 * 
	 * @param ex
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllException(UserNotFoundException ex, WebRequest request) {

		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false),
				ex.getErrorName(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}

	/**
	 * Response structure:-
	 * 
	 *
	 * 
	 * @param ex
	 * @param request
	 * @return
	 * @throws Exception
	 */

	@ExceptionHandler(UserInternalServerException.class)
	public final ResponseEntity<Object> handleAllException(UserInternalServerException ex, WebRequest request) {

		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false),
				ex.getErrorName(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
