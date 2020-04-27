package com.controllerAdviceexample.controllerAdviceexample.exception;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler  {
    
	/*   @ExceptionHandler(AppException.class)
	    public ResponseEntity<CustomErrorResponse> customHandleNotFound(Exception ex, WebRequest request,HttpServletRequest httpRequest) {
	        CustomErrorResponse errors = new CustomErrorResponse();
	        errors.setTimestamp(LocalDateTime.now());
	        errors.setError(ex.getMessage());
	        errors.setStatus(HttpStatus.NOT_FOUND.value());
	        errors.setPath(httpRequest.getRequestURI());
	        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
	    }*/
	    
	    @ExceptionHandler(CustomeException.class)
	    public ResponseEntity<CustomErrorResponse> customeException(CustomeException ex, WebRequest request,HttpServletRequest httpRequest) {
	        CustomErrorResponse errors = new CustomErrorResponse();
	        errors.setTimestamp(LocalDateTime.now());
	        errors.setError(ex.getMessage());
	        errors.setObj(ex.getMessage());
	        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errors.setPath(httpRequest.getRequestURI());
	        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	 /*  @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", status.value());
	        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
	        body.put("errors", errors);
	        return new ResponseEntity<>(body, headers, status);
	    }*/
	    
	   

}
