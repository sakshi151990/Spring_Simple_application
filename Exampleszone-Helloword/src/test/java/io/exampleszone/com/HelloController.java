package io.exampleszone.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello()
	{
		return "Home";
		
	}
	
	
	
	
}
