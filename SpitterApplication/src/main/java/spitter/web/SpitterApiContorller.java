package spitter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spitter.data.Spittle;
import spitter.data.SpittleRepository;

@Controller
@RequestMapping("/spittlesui")
public class SpitterApiContorller {

	private SpittleRepository spittlerepo;
	
	@Autowired
	public SpitterApiContorller(SpittleRepository spittlerepo) {
		super();
		this.spittlerepo = spittlerepo;
	}

	private static final String MAX_LONG_AS_STRING="9223372036854775807";
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Spittle>  spittles(@RequestParam(value= "max" , defaultValue= MAX_LONG_AS_STRING) long max,@RequestParam(value="count", defaultValue="20") int count)
	{
		return spittlerepo.findSpittles(max, count);
		
	}
}
