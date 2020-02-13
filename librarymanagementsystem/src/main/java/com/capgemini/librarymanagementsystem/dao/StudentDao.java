package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.dto.BookInfoBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.dto.User;

public interface StudentDao {

	
	public User loginStudent(String email, String password);
	public List<BookInfoBean> searchBook(String bookName);
	public List<BookInfoBean> allBooks();
	public boolean borrowBook(StudentBean bean);
	public boolean returnBook(int id, int bookid);
	public String getBook(int id);
	
	
}
