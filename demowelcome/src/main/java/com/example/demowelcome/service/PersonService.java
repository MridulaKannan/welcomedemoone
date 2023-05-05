package com.example.demowelcome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demowelcome.dao.Person;
import com.example.demowelcome.dao.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;
	public List<Person> fetchAllpersons()
	{
		 return personRepo.findAll();
	}
	
	public Person savePerson(Person p)
	{
		return personRepo.save(p);
	}
	
}
