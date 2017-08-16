package com.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.annotation.support.PrincipalMethodArgumentResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.data.Questions;
import com.data.User;
import com.data.questionRepository;
import com.data.resultRepository;
import com.data.userRepository;
import com.data.userRoles;
import com.data.userresult;
import com.data.userrolesRepository;

@Controller
@SessionAttributes({ "name", "index", "questionobj", "userresult", "useratt" })

public class HomeController {

	@Autowired
	userRepository userrepository;
	@Autowired
	questionRepository questionrrepository;

	@Autowired
	resultRepository resultrepository;

	// @Autowired
	com.data.resultmailservice resultmailservice;

	@Autowired
	userrolesRepository userrolesrepository;

	@Autowired
	userRoles userroles;

	public HomeController(userRepository userrepository, questionRepository questionrrepository) {
		super();
		this.userrepository = userrepository;
		this.questionrrepository = questionrrepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("user", new User());
		return "Index";
	}

	@RequestMapping(value = "/adminpage", method = RequestMethod.GET)
	public String adminPage(Model model) {
model.addAttribute("questionanswer", new Questions());
		return "Adminpage";
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		System.out.println("logotu");

		return "logout";
	}
	
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public ModelAndView homePage(Principal principal) {
		ModelAndView model = new ModelAndView();
		model.addObject("name", principal.getName());
		User user = findUser(principal.getName());
		model.addObject("index", 0);
		model.setViewName("welcome");
		model.addObject("useratt", user);
		model.addObject("userresult", new userresult());

		return model;
	}
	
	
	@RequestMapping(value = { "/addQuestions" }, method = RequestMethod.POST)
	public ModelAndView addquestions(@ModelAttribute("questionanswer") Questions questions ) {
		ModelAndView model = new ModelAndView();
		questionrrepository.saveQuestionAnswer(questions);
model.setViewName("redirect:/adminpage");
		return model;
	}

	public User findUser(String name) {

		User user1 = userrepository.finduser(name);
		return user1;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorpage(Model model, @ModelAttribute("useratt") User user) {

		return "error";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute("user") User user) {
		userroles.setRole("ROLE_USER");
		userroles.setUser(user);

		user.getUseeroles().add(userroles);
		userrepository.saveUser(user);
		userrolesrepository.saveroles(userroles);

		return "Index";
	}

	/*
	 * @RequestMapping(value = "/{name}", method = RequestMethod.GET) public
	 * String findUser(@PathVariable("name") String name, Model model)
	 * 
	 * {
	 * 
	 * model.addAttribute("name", name); model.addAttribute("index", 0);
	 * 
	 * return "welcome";
	 * 
	 * }
	 */

	@RequestMapping(value = "/QuestionAnswer.html/submit.html", method = RequestMethod.POST)
	public String questionAnswersubmit(@ModelAttribute("questionobj") Questions questionAnswer,
			@ModelAttribute("index") int index, @ModelAttribute("userresult") userresult userresult,
			@RequestParam(value = "answer1") String answer1, Model model) {

	
		int index1 = 0;
		String URI = "";
		if (answer1.equals(questionAnswer.getAnswer())) {
			userresult.setCorrect(userresult.getCorrect() + 1);    
			userresult.setResult(userresult.getResult() + 1);
		} else {
			userresult.setIncorrect(userresult.getIncorrect() + 1);
			
		}

		List<Questions> listQ = questionrrepository.getQuestionAnswer();
		for (Questions quest : listQ) {
			if (quest.getQuestionid() == questionAnswer.getQuestionid()) {
				index1 = listQ.indexOf(quest);
				break;
			}
		}
		if (index1 < listQ.size() - 1) {
			model.addAttribute("sub", "Next");
			
			
			index1 = index1 + 1;
			
			model.addAttribute("index", index1);
			model.addAttribute("userresult", userresult);
			
			
			URI = "redirect:/QuestionAnswer";
			
		} else {
			model.addAttribute("sub", "Finish");
			model.addAttribute("userresult", userresult);
			URI = "redirect:/result";

		}

		return URI;
	}

	@RequestMapping(value = "/QuestionAnswer", method = RequestMethod.GET)
	public ModelAndView showquestion(ModelAndView modelandview, @ModelAttribute("name") String name,
			@ModelAttribute("index") int index, @ModelAttribute("useratt") User user,
			@ModelAttribute("userresult") userresult userresult) {
		List<Questions> listQ = questionrrepository.getQuestionAnswer();

		modelandview.addObject("quest", listQ.get(index));
		modelandview.addObject("questionobj", listQ.get(index));
		modelandview.addObject("userresult", userresult);
		userresult.setUser(user);
		user.getUserresults().add(userresult);
		modelandview.addObject("name", name);
		modelandview.setViewName("questionhome");
		return modelandview;
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView showresult(ModelAndView modelandview, @ModelAttribute("userresult") userresult userresult,
			@ModelAttribute("useratt") User user) {
		List<Questions> listQ = questionrrepository.getQuestionAnswer();
		System.out.println(userresult.getResult());
		System.out.println(listQ.size());
		userresult.setResult((int) ((((double)userresult.getResult())/listQ.size())*100));
		System.out.println(userresult.getResult());
		resultrepository.saveresult(userresult);
		modelandview.addObject("userresult", userresult);
		modelandview.setViewName("result");
		// resultmailservice.sendSimpleSpittleEmail(user, userresult);
		return modelandview;
	}

}
