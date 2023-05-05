package com.example.welcomedemoone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class WelcomeDemoOne {
	
	@Controller
	public class DemoWelcomeController {
		
		@ResponseBody
		@RequestMapping(value="/messages",method=RequestMethod.GET)
		public String welcome()
		{
			return "Hiiii..";
		}
		
	}

}
