package com.example.OfficeData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OfficeData.dao.RegistrationLogin;
@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationLogin,Integer>{
	
	public RegistrationLogin findByUsername(String username);

}
