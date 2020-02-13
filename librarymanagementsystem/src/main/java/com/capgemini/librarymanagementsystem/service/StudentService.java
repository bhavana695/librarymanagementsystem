package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfoBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface StudentService {

	public List<BookInfoBean> searchBook(String bookName);
	public void borrowBook(int studentId);
	public void returnBook(int id);
	public User loginStudent(String email, String password) ;
	public List<BookInfoBean> allBooks();
	
	
	
}
