package student.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentContoller {

	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String StudentHome()
	{
		return  "Home";
	}
	
	@RequestMapping(value="/student" , method=RequestMethod.GET)
	public String Studentadd(@RequestParam("name") String name,@RequestParam("rollno") int rollno,Model model)
	{ model.addAttribute("name", name);
	model.addAttribute("rollno", rollno);
	return "student";
  
	}
	@RequestMapping(value="/student/{rollno}" , method=RequestMethod.GET)
	public String Studentadd(@PathVariable("rollno") int rollno,Model model)
	{ model.addAttribute("name", "John");
	model.addAttribute("rollno", rollno);
	return "student";
  
	}
}
