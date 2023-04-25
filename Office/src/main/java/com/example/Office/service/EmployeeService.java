package com.example.Office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Office.repository.EmployeeClass;
import com.example.Office.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	public List<EmployeeClass> getEmployeeClass()
	{
		List<EmployeeClass>empList=empRepository.findAll();
		return empList;
	}
	
	public EmployeeClass saveEmployeeClass (EmployeeClass e)
	{
		return empRepository.save(e);
	}
	
	public EmployeeClass updateEmployeeClass (EmployeeClass e)
	{
		return empRepository.save(e);
	}
	
	public void deleteEmployeeClass(int empId)
	{
		empRepository.deleteById(empId);
	}
}
