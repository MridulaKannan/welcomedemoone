package com.example.OfficeData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.OfficeData.dao.EmployeeDb;
import com.example.OfficeData.dao.ProjectDetails;
import com.example.OfficeData.dao.RegistrationDb;
import com.example.OfficeData.dao.RegistrationLogin;
import com.example.OfficeData.service.RegistrationService;

import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
public class RegistrationController {
	@Autowired
	RegistrationService regService;
	
	//login page
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchRegistrationLogin")
	public List<RegistrationLogin> getRegistrationLogin()
	{
		List<RegistrationLogin> regList=regService.getRegistrationLogin();
		return regList;
	}
	
	@Tag(name="Post", description="Post data")
	@PostMapping(value="/checkLogin")
		public String validateRegistrationLogin(@RequestBody RegistrationLogin r)
		{
		System.out.println(r.getUsername());
			return regService.validateRegistrationLogin(r.getUsername(),r.getPassword());
		}
	
	@Tag(name="Post", description="Post data")
	@PostMapping(value="/addRegistrationLogin")
	public RegistrationLogin saveRegistrationLogin(@RequestBody RegistrationLogin r)
	{
	return regService.saveRegistrationLogin(r);
	
	}
	
	//registrationDb
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchRegistrationDb")
	public List<RegistrationDb> getRegistrationDb()
	{
		List<RegistrationDb> regDb=regService.getRegistrationDb();
		return regDb;
	}
	@Tag(name="Post", description="Post data")
	@PostMapping(value="/saveRegistrationDb")
	public  RegistrationDb saveRegistrationDb(@RequestBody RegistrationDb d)
	{
		 return regService.saveRegistrationDb(d);
	}
	//sorting
	@Tag(name="Get", description="get data")
	@GetMapping(value="/sortRegistrationDb/{field}")
	public List<RegistrationDb> sortRegistrationDb(@PathVariable String field)
	{
		return regService.sortRegistrationDb(field);
	}
	
	//Paging interface
	@Tag(name="Get", description="get data")
	@GetMapping("/pagingRegistrationDb/{offset}/{pageSize}")
	public List<RegistrationDb> pagingRegistrationDb(@PathVariable int offset,@PathVariable int pageSize)
	{
		return regService.pagingRegistrationDb(offset,pageSize);
	}
	
	@Tag(name="Get", description="get data")
	@GetMapping("/pagingsRegistrationDb/{offset}/{pageSize}")
	public Page<RegistrationDb> pagingsRegistrationDb(@PathVariable int offset,@PathVariable int pageSize)
	{
		return regService.pagingsRegistrationDb(offset,pageSize);
	}
	
	//paging and sorting
	@Tag(name="Get", description="get data")
	@GetMapping("/pagingAndSortingRegistrationDb/{offset}/{pageSize}/{field}")
	public List<RegistrationDb> pagingAndSortingRegistrationDb(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return regService.pagingAndSortingRegistrationDb(offset,pageSize,field);
	}
	
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchEmployeeDb")
	public List<EmployeeDb> getEmployeeDb()
	{
		List<EmployeeDb> regList1=regService.getEmployeeDb();
		return regList1;
	}
	//queries
	@Tag(name="Get", description="get data")
	@GetMapping("/getEmployeeDbByEmpLastName/{empLastName}/{empFirstName}")
	public List<EmployeeDb> getEmployeeDbByEmpLastName(@PathVariable String empLastName,@PathVariable String empFirstName)
	{
		return regService.getEmployeeDbByEmpLastName(empLastName,empFirstName);
	}

	//DML
	@Tag(name="Delete", description="Delete data")
	@DeleteMapping("/deleteRegistrationDbByUserName/{username}")
	public String deleteRegistrationDbByUserName(@PathVariable String username)
	{
	int result=regService.deleteRegistrationDbByUserName(username);
	if(result >0)
		return "Employee record deleted";
	else
		return "Problem occured while deleting";
	}
	@Tag(name="Put", description="Put data")
	@PutMapping("/updateEmployeeDb/{empLastName}/{empFirstName}")
	public String updateEmployeeDb(@PathVariable String empLastName,@PathVariable String empFirstName)
	{
		int result=regService.updateEmployeeDb(empLastName,empFirstName);
		if(result>0)
			return "Student record updated";
		else
			return "Problem occured while updating";
	}
	//native 
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchEmpDivison/{empDivison}")
	public List<EmployeeDb> fetchEmpDivison(@PathVariable String empDivison)
	{
		return regService.fetchEmpDivison(empDivison);
	}
	
	//one to one
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchAllProjectDetails")
	public List<ProjectDetails> fetchAllProjectDetails()
	{
		return regService.fetchAllProjectDetails();
	}
	
	@Tag(name="Post", description="Post data")
	@PostMapping(value="/saveProjectDetails")
	public ProjectDetails saveProjectDetails(@RequestBody ProjectDetails p )
	{
		return regService.saveProjectDetails(p);
	}
	//derived queries
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchByEmpFirstNameStartingWith")
	public List<EmployeeDb> fetchByEmpFirstNameStartingWith(@RequestParam String prefix)
	{
		return regService.fetchByEmpFirstNameStartingWith(prefix);
	}
	@Tag(name="Get", description="get data")
	@GetMapping(value="fetchByEmpLastNameEndingWith")
	public List<EmployeeDb> fetchByEmpLastNameEndingWith(@RequestParam String suffix)
	{
		return regService.fetchByEmpLastNameEndingWith(suffix);
	}
	
}
