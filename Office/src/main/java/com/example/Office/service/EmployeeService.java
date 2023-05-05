package com.example.Office.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.Office.dao.EmployeeClass;
import com.example.Office.dao.Registration;
import com.example.Office.repository.EmployeeRepository;
import com.example.Office.repository.RegisteredEmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	RegisteredEmployeeRepository regRepository;
	
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
	//Sorting Interface
	public List<Registration> getRegistration()
	{
		List<Registration>regList=regRepository.findAll();
		return regList;
	}
	public List<Registration> sortRegistration(String field)
	{
		//return empRepository.findAll(Sort.by(field));
		return regRepository.findAll(Sort.by(Direction.DESC,field));
	}
}
