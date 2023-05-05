package com.example.OfficeData.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ProjectDetails {

	@Id
	@GeneratedValue
	private int projectId;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public EmployeeDb getEmployeeDb() {
		return employeeDb;
	}
	public void setEmployeeDb(EmployeeDb employeeDb) {
		this.employeeDb = employeeDb;
	}
	private String projectName;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id")
	private EmployeeDb employeeDb;

}
