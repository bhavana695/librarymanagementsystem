package com.capgemini.librarymanagementsystem.daoimpl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDaoInterface;
import com.capgemini.librarymanagementsystem.dto.BookInfoBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class AdminDao implements AdminDaoInterface {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	public User loginAdmin(String email, String password) {
		User user = null;
		Book book = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from user where email=? and password=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user=new User();
				user.setEmail(rs.getString("email"));	
				user.setId(rs.getInt("Id"));
				user.setUsertype(rs.getString("usertype"));
				user.setUsername(rs.getString("username"));
				user.setContact(rs.getLong("contact"));
			} 

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;

	}



	public boolean updateUser( int id, User user) {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";

			con = DriverManager.getConnection(dburl);
			String qry = "update user set username =?  ,password=?,email=?,contact=? where  Id=?";

			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setLong(4, user.getContact());
			pstmt.setInt(5, id);


			int n=pstmt.executeUpdate();
			if(n !=0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(int id) {
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from user where Id=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}


	public List<String> viewAllUsers(String type) {

		List<String> user = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from user where usertype=?";
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.add(type);
				user.add(rs.getString(2));
				user.add(rs.getString(3));
				user.add(rs.getString(4));
				user.add(rs.getString(5));
				user.add(rs.getString(6));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public List<String> searchAllBooks(String name) {
		List<String> book = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select *  from book_info where Bookname=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				book.add(rs.getString("Bookname"));
				book.add(rs.getString("Authorname"));
				book.add(rs.getString("Price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;

	}

	@Override
	public boolean add(User u) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "insert into user values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, u.getUsertype());
			pstmt.setString(2, u.getUsername());
			pstmt.setInt(3, u.getId());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getEmail());
			pstmt.setLong(6, u.getContact());

			int r = pstmt.executeUpdate();
			if (r != 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addbook(BookInfoBean bean) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			
			String qry = "insert into book_info values (?,?,?,?,?)";
			pstmt =con.prepareStatement(qry);

			
			pstmt.setInt(1, bean.getBookid());
			pstmt.setString(2, bean.getBookname());
			pstmt.setString(3, bean.getAuthorname());
			pstmt.setDouble(4, bean.getPrice());
			pstmt.setInt(5, bean.getQuantity());
			int c = pstmt.executeUpdate();
			if (c != 0) {
			  return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}



	@Override
	public boolean deleteBook(int id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from book_info where Bookid=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			int rs=pstmt.executeUpdate();
			if(rs>0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return false;
	}



	



	










}

