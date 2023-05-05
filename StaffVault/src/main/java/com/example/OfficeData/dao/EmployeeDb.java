package com.example.OfficeData.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity	
@Table(name="employee_db")
public class EmployeeDb {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	public EmployeeDb() {
		super();
	}
	public EmployeeDb(int empId, String empFirstName, String empLastName, String empDesignation, int empExperience,
			String empDivison, String empShift, long empSalary) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empDesignation = empDesignation;
		this.empExperience = empExperience;
		this.empDivison = empDivison;
		this.empShift = empShift;
		this.empSalary = empSalary;
	}
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
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
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
		this.empDivison = empDivison;
	}
	public String getEmpShift() {
		return empShift;
	}
	public void setEmpShift(String empShift) {
		this.empShift = empShift;
	}
	public long getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}
	private String empFirstName;
	private String empLastName;
	private String empDesignation;
	private int empExperience;
	private String empDivison;
	private String empShift;
	private long empSalary;
	
	

}
