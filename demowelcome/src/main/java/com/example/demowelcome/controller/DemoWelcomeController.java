package com.example.demowelcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoWelcomeController {
	
	@ResponseBody
	@RequestMapping(value="/message",method=RequestMethod.GET)
	public String welcome()
	{
		return "Hiiii......This........is.......Hariniiiiiiiiiiiiiiiiii.....................From.............Thiruvarur";
	}
	
}
