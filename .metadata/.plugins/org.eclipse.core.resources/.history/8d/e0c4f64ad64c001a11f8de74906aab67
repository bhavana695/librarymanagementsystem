package com.capgemini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.serviceimpl.Admin;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.User;

public class AdminController {
	static Logger log = LogManager.getLogger("admin");
	Scanner scan = new Scanner(System.in); 
    void  details(){

    log.info("Admin Selected");
    log.info("Enter username: ");
    int id = scan.nextInt();
    log.info("Enter password: ");
    String pass = scan.next();
	log.info("Admin Login successfully");
	log.info(" Choose Admin operations: ");
	log.info("1.view users");
	
	log.info("2.add User");
	log.info("3.delete User");
	log.info("4.update User");
	log.info("5.Search Book");
	log.info("6.Add Book");
	log.info("7.login");
	
	int i = scan.nextInt();
	switch (i) {
	case 1: {
		Admin a1 = new Admin();
		List<String> result = a1.viewAllUsers("Student");
		for (String str : result) {
			System.out.println(str);
		}
		break;
	}
	case 2: 
	
	{
		
		Admin a2 = new Admin();
        
		System.out.println(a2.add(new User("student","shivam", 19, "xcv ", "cvb", 6)));
		break;
	}
	case 3: {
		Admin a3 = new Admin();
		boolean delete = a3.deleteUser("1");
		System.out.println("record deleted:" + delete);

		break;
	}
	case 4: {
		Admin a4 = new Admin();
		boolean update = a4.updateUser("9");
		System.out.println("record update:" + update);
		break;
	}
	
	case 5:{
		Admin a5=new Admin();
		List<String> search=a5.searchAllBook("c");
		System.out.println("Searched book is:"+search);
		break;
	}
	
	case 6:{
		  Admin a6=new Admin();
				  
		
		System.out.println(a6.addbook(new BookInfo ("FE2","Data Structure","raman",300.5,10)));
		System.out.println("Book added successfully");
		
		
	}
	case 7:{
		Admin a5 = new Admin();
		a5.loginAdmin("2", "Abc");
		
	}
	default: {
		System.out.println("Invalid Choice...");
	}

	
}

}

	
	
	
	
	
	
}
