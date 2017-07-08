package spitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.data.SpittleRepository;

@Controller

public class SpittleController {
	
	SpittleRepository spittlerepository;

	@Autowired
	public SpittleController(SpittleRepository spittlerepository) {
		super();
		this.spittlerepository = spittlerepository;
	}

	@RequestMapping(value="/spittles",method=RequestMethod.GET)
	public String spittles(@RequestParam("max") long max,@RequestParam("count") int count,Model model){
		model.addAttribute("spittleList",spittlerepository.findSpittles(max, count));
		return "spittles";
		
	}
	/*@RequestMapping(value="/spittles",method=RequestMethod.GET)
	public String spittleslist(Model model){
		model.addAttribute("spittleList",spittlerepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
		
	}*/
	
	
	@RequestMapping(value="/spittles/{spittleid}",method=RequestMethod.GET)
	public String spittlesid(@PathVariable("spittleid") long spittleid, Model model){
		model.addAttribute("spittle",spittlerepository.findOne(spittleid));
		return "spittle";
		
	}
	
	
}
