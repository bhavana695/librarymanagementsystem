package com.capgemini.librarymanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.exceptions.InvalidOptionException;

public class LibraryManagementSystem {


	static Logger log = LogManager.getLogger("main");
	static Scanner scan = new Scanner(System.in);

	static int choice = 0;
	public static void main(String[] args) {
		log.info("Welcome to Library");
		do {
			log.info("Select from the following options:");
			log.info("1. Admin");

			log.info("2. Student");
			log.info("--------------------------");

			log.info("Enter your choice");
			log.info("--------------------------");

			int choice = scan.nextInt();

			switch(choice) {

			case 1 : {
				AdminController admin = new AdminController();

				admin.details();
			}
			break;

			case 2: {
				StudentController student = new StudentController();

				student.details();
			}
			break;


			default:
				try {
					throw new InvalidOptionException();
				} catch(Exception e) {
					log.info("Invalid Option!!");
				}
              
			}


		} while(choice!=3);

		scan.close();

	}



}
