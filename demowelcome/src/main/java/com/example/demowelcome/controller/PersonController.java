package com.example.demowelcome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demowelcome.dao.Person;
import com.example.demowelcome.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personSer;
	
	@GetMapping(value="fetchAllpersons")
	public List<Person> fetchAllpersons()
	{
		return personSer.fetchAllpersons();
	}
	
	@PostMapping(value="/savePerson")
	public Person savePerson(@RequestBody Person p )
	{
		return personSer.savePerson(p);
	}
}
