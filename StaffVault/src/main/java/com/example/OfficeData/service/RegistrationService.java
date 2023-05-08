package com.example.OfficeData.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.OfficeData.dao.EmployeeDb;
import com.example.OfficeData.dao.ProjectDetails;
import com.example.OfficeData.dao.RegistrationDb;
import com.example.OfficeData.dao.RegistrationLogin;
import com.example.OfficeData.repository.EmployeeDbRepository;
import com.example.OfficeData.repository.ProjectDetailsRepository;
import com.example.OfficeData.repository.RegistrationDbRepository;
import com.example.OfficeData.repository.RegistrationRepository;
//import com.example.demowelcome.dao.Student;


import jakarta.transaction.Transactional;



@Service
public class RegistrationService {
	@Autowired
	RegistrationRepository regRepo;
	@Autowired
	RegistrationDbRepository regDbRepo;
	@Autowired
	EmployeeDbRepository empDbRepo;
	@Autowired
	ProjectDetailsRepository proRepo;
	
	//login
	public List<RegistrationLogin> getRegistrationLogin()
	{
		List<RegistrationLogin> regList=regRepo.findAll();
		return regList;
	}
	
	public RegistrationLogin saveRegistrationLogin(RegistrationLogin r)
	{
		return regRepo.save(r);
	}
	
	public String validateRegistrationLogin(String username,String password)
	{
		String result="";
		RegistrationLogin r=regRepo.findByUsername(username);
		if(r==null)
		{
			result="Invalid user";
		}
		else
		{
				if(r.getPassword().equals(password))
				{
					result="Login success";
				}
				else
				{
					result="Login failed";
				}
		}
		return result;
	}
	
	//registration
	public List<RegistrationDb> getRegistrationDb()
	{
		List<RegistrationDb> regDb=regDbRepo.findAll();
		return regDb;
	}
	public RegistrationDb saveRegistrationDb(RegistrationDb d) {
		 return regDbRepo.save(d);
	}
	//sorting interface
	
		public List<RegistrationDb> sortRegistrationDb(String field)
		{
			//return regDbRepo.findAll(Sort.by(field));
			return regDbRepo.findAll(Sort.by(Direction.DESC,field));
		}
		
		//pageable interface(pagenation)-offset(pageno),pagesize
		
		//to return in list
		public List<RegistrationDb> pagingRegistrationDb(int offset, int pageSize) 
		{
			Pageable paging=PageRequest.of(offset,pageSize);
			Page<RegistrationDb>regData= regDbRepo.findAll(paging);
			List<RegistrationDb>regList=regData.getContent();
			return regList;
		}
		
		//to return in page
		public Page<RegistrationDb> pagingsRegistrationDb(int offset, int pageSize) 
		{
			Pageable paging=PageRequest.of(offset,pageSize);
			Page<RegistrationDb>regData= regDbRepo.findAll(paging);
			return regData;
		}
		//paging and sorting
		public List<RegistrationDb> pagingAndSortingRegistrationDb(int offset,
				int pageSize,String field) {
			Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			//Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
				Page<RegistrationDb> reg=regDbRepo.findAll(paging);
				return reg.getContent();
		}
		public List<EmployeeDb> getEmployeeDb()
		{
			List<EmployeeDb> regList1=empDbRepo.findAll();
			return regList1;
		}
		//queries
		public List<EmployeeDb> getEmployeeDbByEmpLastName(String empLastName,String empFirstName)
		{
			return empDbRepo.getEmployeeDbByEmpLastName(empLastName,empFirstName);
		}
		
		//native query
		public List<EmployeeDb> fetchEmpDivison(String empDivison)
		{
			return empDbRepo.fetchEmpDivison(empDivison);
		}
		

		//DML
		@Transactional
		public int deleteRegistrationDbByUserName(String username)
		{
			return regDbRepo.deleteRegistrationDbByUserName(username);
		} 
		@Transactional
		public int updateEmployeeDb(String empLastName, String empFirstName)
		{
			return empDbRepo.updateEmployeeDb(empLastName,empFirstName);
		}

		
		//one to one 
		public List<ProjectDetails> fetchAllProjectDetails()
		{
			 return proRepo.findAll();
		}
		
		public ProjectDetails saveProjectDetails(ProjectDetails p)
		{
			return proRepo.save(p);
		}
		//derived queries
		public List<EmployeeDb> fetchByEmpFirstNameStartingWith(String prefix)
		{
			 return empDbRepo.findByEmpFirstNameStartingWith(prefix);
		}
		public List<EmployeeDb> fetchByEmpLastNameEndingWith(String suffix)
		{
			return empDbRepo.findByEmpLastNameEndingWith(suffix);
		}
		
}
