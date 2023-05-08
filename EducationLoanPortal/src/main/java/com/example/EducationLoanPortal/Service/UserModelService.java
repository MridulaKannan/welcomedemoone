package com.example.EducationLoanPortal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EducationLoanPortal.Model.UserModel;
import com.example.EducationLoanPortal.Repository.UserModelRepository;

@Service
public class UserModelService {
	
	@Autowired
	UserModelRepository userRepo;

	
	public List<UserModel> getLogin() 
	{
		return userRepo.findAll();
	}
	
	public UserModel saveLogin(UserModel u)
	{
		return userRepo.save(u); 
	}
	
	public String validateUserLogin(String email,String password)
	{
		UserModel u=userRepo.findByEmail(email);
		if(u==null)
		{
			return "Invalid user";
		}
		else
		{
			if(u.getPassword().equals(password))
			{
				return "Login success";
			}
			else
			{
				return "Login failed";
			}
		}
	}

	public void deleteUser(int id) 
	{
		userRepo.deleteById(id);
	}

}
