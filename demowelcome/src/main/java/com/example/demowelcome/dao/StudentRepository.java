package com.example.demowelcome.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

	//Derived queries
	public List<Student> findByName(String name);
	public List<Student> findByNameStartingWith(String prefix);
	public List<Student> findByNameEndingWith(String prefix);
	public List<Student> findByDepartment(String department);
	
	//DML
	@Modifying
	@Query("delete  from Student s where s.name=?1" )
	public int deleteStudentByName(String name);
	
//	@Modifying
//	@Query("update from Student s set s.department=?1 where s.name=?2")
//	public int updateStudentByName(String department,String name);
//	
	//query with delete query
	//@Query(value="select * from Student  s where  s.email= ?1", 
			// nativeQuery=true)
	 	//public List<Student> fetchStudentByMail(String  mail);

}
