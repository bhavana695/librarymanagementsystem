package com.capgemini.librarymanagementsystem.serviceimpl;

import java.util.List;

import com.capgemini.librarymanagementsystem.daoimpl.StudentImpl;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.service.StudentInterface;

public class Student implements StudentInterface{
	
	
	private StudentImpl impl = new StudentImpl();
    StudentDTO u=new StudentDTO();
    BookInfo b=new BookInfo();

	public Student() {
		super();
	}

	
	public Student(BookInfo b) {
		super();
		this.b = b;
	}


	public Student(StudentDTO u) {
		super();
		this.u = u;
	}


	public StudentDTO loginStudent(int id, String password) {
		
		return  impl.loginStudent( id,  password);
	} 
	
	
	public BookInfo searchAllBook(int bookname) {

		
		BookInfo res1=impl.searchBook(bookname);
		return res1;
	}
		
		
	

	@Override
	public void borrowBook() {
		
		
		
	}

	@Override
	public void returnBook() {
		
		
	}


	@Override
	public BookInfo searchBook(int bookid) {
		// TODO Auto-generated method stub
		return null;
	}

}
