package com.example.OfficeData.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OfficeData.dao.EmployeeDb;

@Repository
public interface EmployeeDbRepository extends JpaRepository<EmployeeDb,Integer>{

	//positional parameter
		@Query("select s from EmployeeDb s where s.empLastName=?1 and s.empFirstName=?2")
		public List<EmployeeDb> getEmployeeDbByEmpLastName(String empLastName,String empFirstName);
		
		//named parameter
		@Query("select s from EmployeeDb s where s.empLastName=:empLastName")
		public List<EmployeeDb> getEmployeeDbByEmpLastName1(String empLastName);
		
		@Query(value="select * from employee_db s where s.emp_divison=?1",nativeQuery=true)
		public List<EmployeeDb> fetchEmpDivison(String empDivison);


	//DML
		
		
		@Modifying
		@Query("update EmployeeDb s set s.empLastName=?1 where s.empFirstName=?2")
		public int updateEmployeeDb(String empLastName,String empFirstName);
		
		//derived queries
		List<EmployeeDb>findByEmpFirstNameStartingWith(String prefix);
		List<EmployeeDb>findByEmpLastNameEndingWith(String suffix);

}
