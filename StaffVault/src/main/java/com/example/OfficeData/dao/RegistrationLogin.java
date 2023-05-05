package com.example.OfficeData.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RegistrationLogin {
	@Id
	@GeneratedValue
	private int empId;
	public RegistrationLogin() {
		super();
	}
	public RegistrationLogin(int empId, String username, String password) {
		super();
		this.empId = empId;
		this.username = username;
		this.password = password;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getUsername() {
		return username;
	}
	public int getEmpId() {
		return empId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String username;
	private String password;

}
