package student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import student.data.Student;


@Controller
public class StudentContoller {
	@Autowired
	private Student student;

	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String StudentHome()
	{
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
	public String Studentresgister(@RequestParam("name") String name, @RequestParam("rollno") int rollno)
	{
		student.setName(name);
		student.setRollno(rollno);
		
		return "redirect:/"  + student.getName(); 
		
	}
	
	
	@RequestMapping(value="/{name}" , method=RequestMethod.GET)
	public String Studentprofile(Model model)
	{
		model.addAttribute("name", student.getName());
		model.addAttribute("rollno", student.getRollno());
		return "Profile";
	}
}
