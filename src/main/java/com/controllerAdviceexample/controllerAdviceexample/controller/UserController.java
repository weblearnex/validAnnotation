package com.controllerAdviceexample.controllerAdviceexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controllerAdviceexample.controllerAdviceexample.exception.AppException;
import com.controllerAdviceexample.controllerAdviceexample.exception.CustomeException;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String welcome(){
		
		return "application up and running";
	}
	
	@GetMapping("/exception")
	public String getException(){
		try{
		System.out.println(10/0);
		}catch(Exception ex){
			throw new AppException("Error while calling handleException");
		}
		return "application up and running";
	}
	
	@GetMapping("/handleException")
	public String handleException(){
		try{
			System.out.println(10/0);
			return "application up and running";
		}catch(Exception ex){
			 throw new CustomeException("Error while calling handleException",ex.getMessage());
		}
		
	}
	
	@GetMapping("/appException")
	public String appException(){
		try{
		try{
			 System.out.println("in side of app exception body");
		}catch(Exception ex){
			 throw new CustomeException("Error while calling handleException",ex.getCause());
		}
		 System.out.println(10/0);
		}catch(Exception ex){
			throw new AppException("Error while calling handleException");
		}
		return "application up and running";
	}
	
}
