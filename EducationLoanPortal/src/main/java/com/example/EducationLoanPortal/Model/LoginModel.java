package com.example.EducationLoanPortal.Model;

public class LoginModel {
	
	private String Email;
	private String Password;
	@Override
	public String toString() {
		return "LoginModel [Email=" + Email + ", Password=" + Password + "]";
	}
	public LoginModel() {
		super();
	}
	public LoginModel(String email, String password) {
		super();
		Email = email;
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
