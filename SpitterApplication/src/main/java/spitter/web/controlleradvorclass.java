package spitter.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import spitter.exceptions.duplicateSpitterExecption;

@ControllerAdvice
public class controlleradvorclass {

	@ExceptionHandler(duplicateSpitterExecption.class)
	public String handleduplicatexceiton()
	{   System.out.println("error page");
		return "error";
	}
}
