package com.capgemini.librarymanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LibraryManagementSystem {

	
	static Logger log = LogManager.getLogger("Management");
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		log.info("Welcome to Library Management System");
		log.info("Select from the following options:");
		log.info("For Admin Login, press 1");
//		log.info("For Faculty Login, press 2");
		log.info("For User Login, press 2");
		
		int choice = scan.nextInt();
		
	    switch(choice) {
	    
	    case 1 : AdminController admin = new AdminController();
	    admin.details();
	    break;
	    
	    case 2: StudentController student = new StudentController();
	    student.details();
	    break;
	    }
	    
	    
	    
	    
	}
	
	
	
	
	
	
	
}
