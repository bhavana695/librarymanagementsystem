package com.capgemini.librarymanagementsystem.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dao.StudentDao;
import com.capgemini.librarymanagementsystem.dto.BookInfoBean;
import com.capgemini.librarymanagementsystem.dto.StudentBean;
import com.capgemini.librarymanagementsystem.dto.User;

public class StudentImpl implements StudentDao {

	public User loginStudent(String email, String password) {
		User student=new User();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "select * from user where Id=? and password=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,email );
			pstmt.setString(2,password );
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				student.setEmail(rs.getString("email"));
				student.setId(rs.getInt("Id"));
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
		return student;

	}

	public List<BookInfoBean> searchBook(String bookName) {

		StudentBean student=null;
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookInfoBean> info=new ArrayList<BookInfoBean>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "select * from book_info where Bookname = ?" ;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setString(1,bookName );
			rs = pstmt.executeQuery();
			while(rs.next()) {

				BookInfoBean bean=new BookInfoBean();
				bean.setBookname(rs.getString("Bookname"));
				bean.setAuthorname(rs.getString("Authorname"));
				bean.setPrice(rs.getInt("Price"));
				bean.setQuantity(rs.getInt("Quantity"));
				info.add(bean);

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

	public List<BookInfoBean> allBooks() {
		
		Connection conn =null;
		Statement pstmt = null;
		ResultSet rs = null;
		List<BookInfoBean> info=new ArrayList<BookInfoBean>();;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "select * from book_info " ;
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(query);
			while(rs.next()) {

				BookInfoBean bean=new BookInfoBean();
				bean.setBookid(rs.getInt("Bookid"));
				bean.setBookname(rs.getString("Bookname"));
				bean.setAuthorname(rs.getString("Authorname"));
				bean.setPrice(rs.getInt("Price"));
				bean.setQuantity(rs.getInt("Quantity"));
				info.add(bean);

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

	public boolean borrowBook(StudentBean bean) {
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		List<BookInfoBean> info=new ArrayList<BookInfoBean>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "insert into student_info values(?,?,?,?,?)" ;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setInt(1,bean.getId() );
			pstmt.setInt(2,bean.getBook_id() );
			pstmt.setString(3,bean.getBookname() );
		    pstmt.setString(4,bean.getBorrow_date() );
		    pstmt.setString(5,bean.getReturn_date() );
			int rs = pstmt.executeUpdate();
			if(rs>0) {
				return true;
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

				} 

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	

		return false;
	}

	@Override
	public boolean returnBook(int id, int bookid) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		List<BookInfoBean> info=new ArrayList<BookInfoBean>();
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "delete from student_info where Id=? and Bookid=?" ;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			pstmt.setInt(1,id );
			pstmt.setInt(2,bookid );
			
			int rs = pstmt.executeUpdate();
			if(rs>0) {
				return true;
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

				} 

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	

		

		return false;
	}

	@Override
	public String getBook(int id) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance(); // more beneficial

			String dburl = "jdbc:mysql://localhost:3306/librarymanagementsystem_db";

			conn = DriverManager.getConnection(dburl, "root", "root");

			String query = "select * from book_info where Bookid=? " ;
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {

			return rs.getString("Bookname");
				

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
		
		return null;
	}

}	











