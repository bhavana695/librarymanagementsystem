package com.capgemini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.librarymanagementsystem.daoimpl.StudentImpl;
import com.capgemini.librarymanagementsystem.dto.BookInfoBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.StudentService;
import com.capgemini.librarymanagementsystem.serviceimpl.StudentServiceImpl;
import com.capgemini.librarymanagementsystem.serviceimpl.Admin;

public class StudentController {

	static Logger log = LogManager.getLogger("student");

	StudentService service=new StudentServiceImpl();

	void details() {
		Scanner scan = new Scanner(System.in);
		log.info("Student Selected");
		log.info("Please Login");
		Scanner scanner = new Scanner(System.in);
		log.info("Enter student email");
		String email = scanner.nextLine();
		log.info("Enter password");
		String password = scanner.next();
		User bean= service.loginStudent(email, password);
		if(bean!=null) {	
			log.info("Student logged in successfully");

			log.info(" Choose student operations: ");
			log.info("1.Search book");
			log.info("2.Borrow book");
			log.info("3.Return book");
			log.info("4.Show all books");


			int i = scan.nextInt();
			switch (i) {
			case 1: {
				StudentImpl s1 = new StudentImpl();
				System.out.println("Enter the book name");
				scan.nextLine();
				String search=scan.nextLine();
				List<BookInfoBean> books = s1.searchBook(search);

				if(!books.isEmpty()) {
					for (BookInfoBean bookInfo : books) {
						log.info("Book Name    :"+bookInfo.getBookname());
						log.info("Author name  :"+bookInfo.getAuthorname());
						log.info("Price        :"+bookInfo.getPrice());
					}
				}else {
					log.info("No Book found");
				}
			}
			break;
			case 2: 
				int studentId=bean.getId();
				service.borrowBook(studentId);
				break;


			case 3: 

				int Id=bean.getId();
				service.returnBook(Id);

				break;
			case 4:
				log.info("------All Books---------");
				List<BookInfoBean> beans=service.allBooks();
				if(!beans.isEmpty()) {

					for (BookInfoBean bookInfoBean : beans) {

						log.info(bookInfoBean.getBookid()+")"+bookInfoBean.getBookname());

					}
				}
				break;
				default :
					log.info("Invalid");

			}
		}else {
			log.info("Invalid credentials!");
		}
	}
}
