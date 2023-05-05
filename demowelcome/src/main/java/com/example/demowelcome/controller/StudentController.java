package com.example.demowelcome.controller;

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

import com.example.demowelcome.dao.Student;
import com.example.demowelcome.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studService;

	@GetMapping(value="fetchStudents")
	public List<Student> getAllStudents()
	{
		List<Student> studList=studService.getAllStudents();
		return studList;
	}
	//http://localhost9080/saveStudent
	

	@PostMapping(value="/saveStudent")
	public  Student saveStudent(@RequestBody Student s)
	{
		 return studService.saveStudent(s);
	}
	
	@PutMapping(value="/updateStudent/{rno}")
	public  Student updateStudent(@RequestBody Student s,@PathVariable int rno)
	{
		 return studService.updateStudent(s,rno);
	}
	
	@DeleteMapping("/deleteStudent/{rno}")
	public  void deleteStudent(@PathVariable("rno") int rno)
	{
		  studService.deleteStudent(rno);
	}
	
	//Sorting Interface
	
	@GetMapping(value="/sortStudent/{field}")
	public List<Student> sortStudents(@PathVariable String field)
	{
		return studService.sortStudents(field);
	}
	
	//Paging interface
	@GetMapping("/pagingStudent/{offset}/{pageSize}")
	public List<Student> pagingStudents(@PathVariable int offset,@PathVariable int pageSize)
	{
		return studService.pagingStudents(offset,pageSize);
	}
	
	@GetMapping("/pagingsStudent/{offset}/{pageSize}")
	public Page<Student> pagingsStudents(@PathVariable int offset,@PathVariable int pageSize)
	{
		return studService.pagingsStudents(offset,pageSize);
	}
	//paging and sorting
	
	@GetMapping("/pagingAndSortingStudent/{offset}/{pageSize}/{field}")
	public List<Student> pagingAndSorting(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return studService.pagingAndSorting(offset,pageSize,field);
	}
	
	//Derived queries
	@GetMapping("/fetchStudentByName")
	public List<Student> fetchStudentByName(@RequestParam String name)
	{
		 return studService.fetchStudentByName(name);
	}
	@GetMapping("/fetchStudentByNamePrefix")
	public List<Student> fetchStudentByNamePrefix(@RequestParam String prefix)
	{
		return studService.fetchStudentByNamePrefix(prefix);
	}
	@GetMapping("/fetchStudentByNameSuffix")
	public List<Student> fetchStudentByNameSuffix(@RequestParam String suffix)
	{
		return studService.fetchStudentByNameSuffix(suffix);
	}
	@GetMapping("/fetchStudentByDepartment")
	public List<Student> fetchStudentByDepartment(@RequestParam String department)
	{
		return studService.fetchStudentByDepartment(department);
	}
	
	//DML queries
	@DeleteMapping("/deleteStudentByName/{name}")
	public String deleteStudentByName(@PathVariable String name)
	{
	int result=studService.deleteStudentByName(name);
	if(result >0)
		return "Student record deleted";
	else
		return "Problem occured while deleting";
	}
	
//	@PutMapping(value="/updateStudentByName/{department}")
//	public String updateStudentByName(@PathVariable String department,@PathVariable String name)
//	{
//	int result=studService.updateStudentByName(department,name);
//	if(result >0)
//		return "Student record deleted";
//	else
//		return "Problem occured while deleting";
//	}
//	
	//queries-native query
	//one to one relationship
	
	
	
																																												
}
