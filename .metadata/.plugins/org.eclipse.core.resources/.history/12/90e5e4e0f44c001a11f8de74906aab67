package com.capgemini.librarymanagementsystem.daoimpl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDaoInterface;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.User;


public class AdminDao implements AdminDaoInterface  {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	boolean isAdded;
	String isAdded2 = null;

	public User loginAdmin(String id, String password) {
		User user = null;
		Book book = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from user where Id='" + id + "'and Password='" + password;
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					String name = rs.getString(2);
					String pass = rs.getString(4);
				}
			} else {
				System.out.println("User not exist.........");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;

	}

	public boolean addUser(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "insert into user values(?,?,?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			pstmt.setString(1, "Admin");
			pstmt.setString(2, "Pandit");
			pstmt.setString(3, "111");
			pstmt.setString(4, "p1234");
			pstmt.setString(5, "pandit@gmail.com");
			pstmt.setLong(6, 97865476);
			pstmt.setDouble(7, 200.5);
			int r = pstmt.executeUpdate();
			System.out.println(r);
			if (r != 0) {
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	public boolean updateUser(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";

			con = DriverManager.getConnection(dburl);
			String qry = "update user set User_type ='Teacher'  where Id=? ";
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(String id) {
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from user where Id=?";
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

	@SuppressWarnings("null")
	public List<String> viewAllUsers(String type) {

		List<String> user = new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from user where User_type='" + type + "'";
			PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(qry);
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
	
	public List<String> searchAllBook(String name){
		List<String> book=new ArrayList<String>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry="select *  from book_info where Book_name=?";
			pstmt=(PreparedStatement) con.prepareStatement(dburl);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				book.add(rs.getString(1));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
		
	}

	@Override
	public String add(User u) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "insert into user values(?,?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			pstmt.setString(1, u.getUsertype());
			pstmt.setString(2, u.getUsername());
			pstmt.setInt(3, u.getId());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getEmail());
			pstmt.setLong(6, u.getContact());
			
			int r = pstmt.executeUpdate();
			if (r != 0) {
				isAdded2 = "Successfully Added";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded2;
	}

	public String addbook(BookInfo b) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String qry = "insert into book_info values (?,?,?,?,?)";
			pstmt = (PreparedStatement) con.prepareStatement(qry);
			pstmt.setString(1, b.getBookId());
			pstmt.setString(2, b.getBookname());
			pstmt.setString(3, b.getAuthorname());
			pstmt.setDouble(4, b.getPrice());
			pstmt.setInt(5, b.getQuantity());

			int c = pstmt.executeUpdate();
			if (c != 0) {
				System.out.println("Book added successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded2;

	}

	

	public static void main(String[] args) {
		String res = new AdminDao().add(new User("Admin", "Ankit2", 2, "Abc", "ridz@gmail.com", 83545777L));
		System.out.println(res);
	}

	@Override
	public String addbook(String bookid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchbook(String bookname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int adduser(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int addbook(String bookname, String bookId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
