package com.example.OfficeData.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.OfficeData.dao.RegistrationDb;

@Repository
public interface RegistrationDbRepository  extends JpaRepository<RegistrationDb,Integer>{

	@Modifying
	@Query("delete from RegistrationDb r where r.username=?1")
	public int deleteRegistrationDbByUserName(String username);
}
