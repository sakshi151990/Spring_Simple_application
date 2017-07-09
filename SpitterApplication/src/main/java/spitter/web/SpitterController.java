package spitter.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spitter.data.Spitter;
import spitter.data.spitterRepository;

@Controller
public class SpitterController {
	
	spitterRepository spitterrepository;

	@Autowired
	public SpitterController(spitterRepository mockRepository) {
		super();
		this.spitterrepository = mockRepository;
	}
	
	@RequestMapping(value="/spitter/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
	return "registerForm";
	}
	
	/*@RequestMapping(value="/spitter/register", method=RequestMethod.POST)
	public String processRegistration( 
		
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName")String lastName,
		@RequestParam("username") String username,
		@RequestParam("password") String password){
	Spitter spitter=new Spitter(username,password,lastName,firstName);
	
	spitterrepository.save(spitter);
	return "redirect:/spitter/" +
	spitter.getUsername();
	}*/
	
	@RequestMapping(value="/spitter/register", method=RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,Errors error) {
	if(error.hasErrors())
	{
		return "registerForm";
	}else
	{
	spitterrepository.save(spitter);
	return "redirect:/spitter/" + spitter.getUsername();
	}}

	@RequestMapping(value="/spitter/{username}", method=RequestMethod.GET)

	public String showSpitterProfile(
	@PathVariable String username, Model model) {
	Spitter spitter = spitterRepository.findByUsername(username);
	model.addAttribute(spitter);
	return "Profile";
	}
	
}
