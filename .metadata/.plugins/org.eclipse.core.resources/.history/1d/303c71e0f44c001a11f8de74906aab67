package com.capgemini.librarymanagementsystem.serviceimpl;

import java.util.List;

import com.capgemini.librarymanagementsystem.daoimpl.AdminDao;
import com.capgemini.librarymanagementsystem.dto.BookInfo;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.AdminInterface;



public class Admin implements AdminInterface {

	private AdminDao dao = new AdminDao();
    User u=new User();
    BookInfo b=new BookInfo();


public Admin() {
		super();
	}


public Admin(User user) {
	super();
	this.u = user;
}

public Admin(BookInfo book) {
  super();
  this.b=book;
  
}
public User loginAdmin(String id, String password) {
	return dao.loginAdmin(id, password);
}


public int adduser(String username, String password) {
	
	return  dao.adduser( username,  password);
} 

//public int addbook(String Bookname,String BookId) {
	//return dao.addbook(Bookname,BookId);
//}

public boolean  updateUser(String id) {
	
	return dao.updateUser(id);
	
	
}

public boolean deleteUser(String id) {
	
	return dao.deleteUser(id);
}

public List<String> viewAllUsers(String type) {
	List<String>res =  dao.viewAllUsers(type);
	return res;
}

@Override
public String add(User u) {
	return dao.add(u);
	
}


public String  addbook(BookInfo bookInfo) {
	return dao.addbook(bookInfo);
}


public String addbook(String string, String string2, String string3, double d, int i) {
	return dao.addbook(b);
}


public List<String> searchAllBook(String string) {

	Object String;
	List<String > res1=dao.searchAllBook(string);
	return res1;
}


}
