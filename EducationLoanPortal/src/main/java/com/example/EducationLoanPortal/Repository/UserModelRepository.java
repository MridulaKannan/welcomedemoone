package com.example.EducationLoanPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EducationLoanPortal.Model.UserModel;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Integer>{

	public UserModel findByEmail(String email);
}
