package com.capgemini.librarymanagementsystem.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.StudentDao;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.StudentDTO;
import com.capgemini.librarymanagementsystem.dto.User;

public class StudentImpl implements StudentDao {

	@Override
	public StudentDTO loginStudent(int id, String password) {
		StudentDTO student=null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial
		
		String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";
		
		conn = DriverManager.getConnection(dburl, "root", "root");
		 
		String query = "select * from user where Id='" + id + "'and Password='" + password;
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, student.getId());
			
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
		if(conn!= null) {
			conn.close();
		}
		if(pstmt!= null) {
			pstmt.close();
		
	} if(rs!=null) {
		rs.close();
	}

	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	 }
		return student;

 }

	@Override
	public BookInfo searchBook(int bookid) {
		
		StudentDTO student=null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookInfo info=null;
		try {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial
		
		String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";
		
		conn = DriverManager.getConnection(dburl, "root", "root");
		 
		String query = "select * from book_info where Id= ?" ;
		pstmt = (PreparedStatement) conn.prepareStatement(query);
		pstmt.setInt(1,bookid );
		rs = pstmt.executeQuery();
			if(rs.next()) {
				info=new BookInfo();
				info.setBookname(rs.getString("Bookname"));
				
			}
		
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
		if(conn!= null) {
			conn.close();
		}
		if(pstmt!= null) {
			pstmt.close();
		
	} if(rs!=null) {
		rs.close();
	}

	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	 }
		return info;

 }

	}	



	
		
	

	
	
	

