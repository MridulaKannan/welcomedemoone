package com.example.Office.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Office.dao.EmployeeClass;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeClass,Integer> {

}
