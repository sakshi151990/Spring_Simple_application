package com.examplezone.webexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class SpringwebexamplesApplicationController {

	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String homecontroller()
	{
		return "Home";
		
	}
	
	}

