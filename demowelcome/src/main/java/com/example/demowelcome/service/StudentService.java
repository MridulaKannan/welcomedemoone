package com.example.demowelcome.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.example.demowelcome.dao.PersonRepository;
import com.example.demowelcome.dao.Student;
import com.example.demowelcome.dao.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	StudentRepository studRepository;
	@Autowired
	PersonRepository personRepo;
	

	public List<Student> getAllStudents()
	{
		List<Student>studList=studRepository.findAll();
		return studList;
	}

	public Student saveStudent(Student s) {
		
		
		//Student obj=studRepository.save(s);
		//return obj;
		 return studRepository.save(s);
	}
	
	public Student updateStudent(Student s,int rno) {
		
		Optional<Student>optional=studRepository.findById(rno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRegno(s.getRegno());
			obj.setName(s.getName());
			obj.setDepartment(s.getDepartment());
			obj.setEmail(s.getEmail());
		studRepository.saveAndFlush(s);
		}
		return obj;
		//Student obj=studRepository.save(s);
		//return obj;
		 //return studRepository.save(s);
	}
	
	public void deleteStudent(int regno)
	{
		
		studRepository.deleteById(regno);
	}
	
	//sorting interface
	
	public List<Student> sortStudents(String field)
	{
		//return studRepository.findAll(Sort.by(field));
		return studRepository.findAll(Sort.by(Direction.DESC,field));
	}
	
	//pageable interface(pagenation)-offset(pageno),pagesize
	
	//to return in list
	public List<Student> pagingStudents(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Student>studData= studRepository.findAll(paging);
		List<Student>studList=studData.getContent();
		return studList;
	}
	
	//to return in page
	public Page<Student> pagingsStudents(int offset, int pageSize) 
	{
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Student>studData= studRepository.findAll(paging);
		return studData;
	}
	//paging and sorting
	public List<Student> pagingAndSorting(int offset,
			int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(Direction.DESC,field));
			Page<Student> stud=studRepository.findAll(paging);
			return stud.getContent();
		}
	//Derived queries
	public List<Student> fetchStudentByName(String name)
	{
		return studRepository.findByName(name);
	}
	public List<Student> fetchStudentByNamePrefix(String prefix)
	{
		 return studRepository.findByNameStartingWith(prefix);
	}
	public List<Student> fetchStudentByNameSuffix(String suffix)
	{
		return studRepository.findByNameEndingWith(suffix);
	}
	public List<Student> fetchStudentByDepartment(String department)
	{
		return studRepository.findByDepartment(department);
	}
	
	//DML
	
	@Transactional
	public int deleteStudentByName(String name)
	{
		return studRepository.deleteStudentByName(name);
	} 
	
//	@Transactional
//	public int updateStudentByName(String department,String name)
//	{
//		return studRepository.updateStudentByName(department,name);
//	}
	//
	
	
}

