package com.capgemini.librarymanagementsystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.StudentService;
import com.capgemini.librarymanagementsystem.serviceimpl.StudentServiceImpl;

class LoginTest {

	@Test
	void Logintest() {
	StudentService service=new StudentServiceImpl();
	User actual=service.loginStudent("hghyh", "hghg");
	assertEquals(null, actual);
	}
	
	

}
