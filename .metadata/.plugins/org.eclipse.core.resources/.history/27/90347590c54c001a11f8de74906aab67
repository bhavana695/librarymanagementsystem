 package com.capgemini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.daoimpl.StudentImpl;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.serviceimpl.Admin;

public class StudentController {
	static Logger log = LogManager.getLogger("student");
void details() {
	Scanner scan = new Scanner(System.in);
	log.info("Student Selected");
	log.info("Please Login");
	Scanner scanner = new Scanner(System.in);
	log.info("Enter student id");
	int id = scanner.nextInt();
	log.info("Enter password");
	String password = scanner.next();
	log.info("Student logged in successfully");
	log.info(" Choose student operations: ");
	log.info("1.Search book");
	
	log.info("2.Borrow book");
	log.info("3.Return book");
	
	
	int i = scan.nextInt();
	switch (i) {
	case 1: {
		StudentImpl s1 = new StudentImpl();
		BookInfo r = s1.searchBook(10);
		log.info(r.getBookname());
		}
		break;
	}
	
	
	
}
}
