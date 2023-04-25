package com.example.Office.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Office.repository.EmployeeClass;
import com.example.Office.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@GetMapping(value="fetchEmployee")
	public List<EmployeeClass> getEmployeeClass()
	{
		List<EmployeeClass> empList=empService.getEmployeeClass();
		return empList;
	}
	
	@PostMapping(value="/saveEmployee")
	public EmployeeClass saveEmployeeClass (@RequestBody EmployeeClass e)
	{
		return empService.saveEmployeeClass(e);
	}
	
	@PutMapping(value="/updateEmployeeClass")
	public EmployeeClass updateEmployeeClass(@RequestBody EmployeeClass e)
	{
		return empService.saveEmployeeClass(e);
	}
	
	@DeleteMapping("/deleteEmployeeClass/{eid}")
	public void deleteEmployeeClass(@PathVariable("eid") int empId)
	{
		empService.deleteEmployeeClass(empId);
	}

}
