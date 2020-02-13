package com.capgemini.librarymanagementsystem.validations;


	
	 
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;
	 
	public class ValidatePassword {
	 
	    private static Pattern pattern;
	    private static Matcher matcher;
	 
	    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	 
	    public ValidatePassword() {
	        pattern = Pattern.compile(PASSWORD_PATTERN);
	    }
	 
	    public static boolean validate(final String password) {
	 
	        matcher = pattern.matcher(password);
	        return matcher.matches();
	 
	    }
	}

