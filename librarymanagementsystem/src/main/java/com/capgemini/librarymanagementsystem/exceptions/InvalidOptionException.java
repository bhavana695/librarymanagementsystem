package com.capgemini.librarymanagementsystem.exceptions;

public class InvalidOptionException extends RuntimeException {

 String msg= "Please enter valid option";

public InvalidOptionException() {
	
}
	
 public String getMessage() {
	 
	 return this.msg;
	 }


	
	
	
	
}
