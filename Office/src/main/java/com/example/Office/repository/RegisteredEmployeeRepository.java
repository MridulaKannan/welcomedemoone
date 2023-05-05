package com.example.Office.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Office.dao.Registration;

public interface RegisteredEmployeeRepository extends JpaRepository<Registration,String>{

}

