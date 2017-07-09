package student.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import student.data.Student;


@Controller
public class StudentContoller {


	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String StudentHome(Model model)
	{ model.addAttribute(new Student());
		return  "student";
	}
	
/*	@RequestMapping(value="/student" , method=RequestMethod.GET)
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
  
	}*/
	
	@RequestMapping(value="/" , method=RequestMethod.POST)
	public String Studentresgister(@Valid Student student,Errors error)
	{ if(error.hasErrors()){
		return "student";
	}else
		
		
		return "redirect:/"  + student.getName(); 
		
	}
	
	
	@RequestMapping(value="/{name}" , method=RequestMethod.GET)
	public String Studentprofile(@PathVariable("name") String name ,Model model)
	{
		model.addAttribute("name", name);
		
		return "Home";
	}
}
