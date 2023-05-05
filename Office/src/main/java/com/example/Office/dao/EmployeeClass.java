package com.example.Office.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeClass {
	
	@Id
	private int empId;
	private String empFirstName;
	private String empLastName;
	private String empDesignation;
	private int empExperience;
	private String empDivison;
	private String empTeam;
	private long empSalary;
	private String empRole;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName=empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName=empLastName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation=empDesignation;
	}
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	public String getEmpDivison() {
		return empDivison;
	}
	public void setEmpDivison(String empDivison) {
		this.empDivison=empDivison;
	}
	public String getEmpTeam() {
		return empTeam;
	}
	public void setEmpTeam(String empTeam) {
		this.empTeam=empTeam;
	}
	public long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(long empSalary) {
		this.empSalary=empSalary;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole=empRole;
	}
	
	
}
