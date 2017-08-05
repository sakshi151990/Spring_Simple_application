package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.data.userresult;


@Controller
@SessionAttributes({ "name", "index", "questionobj", "userresult" })

public class HomeController {

	@Autowired
	userRepository userrepository;
	@Autowired
	questionRepository questionrrepository;

	@Autowired
	resultRepository resultrepository;
	
	@Autowired
	userresult userresult;

	public HomeController(userRepository userrepository, questionRepository questionrrepository) {
		super();
		this.userrepository = userrepository;
		this.questionrrepository = questionrrepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute(new User());
		return "Index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String findUser(Model model, @ModelAttribute User user) {
		System.out.println("inside finduser" + user.getName());
		User user1 = userrepository.finduser(user.getUserid());
		userresult.setUser(user1);
		user1.getUserresults().add(userresult);
		model.addAttribute("name", user1.getName());
		model.addAttribute("index", 0);
		model.addAttribute("userresult", userresult);
		return "welcome";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveUser(Model model, @ModelAttribute User user) {
		System.out.println("insidesaveuser" + user.getName());
		userrepository.saveUser(user);
		userresult.setUser(user);
		user.getUserresults().add(userresult);
		model.addAttribute("name", user.getName());
		model.addAttribute("index", 0);
		model.addAttribute("userresult", userresult);

		return "welcome";
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
			@RequestParam(value = "answer1") String answer1, Model model) {
		int index1 = 0;
		String URI = "";
		if (answer1.equals(questionAnswer.getAnswer())) {
			userresult.setCorrect(userresult.getCorrect() + 1);
			userresult.setResult(userresult.getResult() + 1);
		} else {
			userresult.setIncorrect(userresult.getIncorrect() + 1);
			userresult.setResult(userresult.getResult() - 1);
		}

		List<Questions> listQ = questionrrepository.getQuestionAnswer();
		for (Questions quest : listQ) {
			if (quest.getQuestionid() == questionAnswer.getQuestionid()) {
				index1 = listQ.indexOf(quest);
				break;
			}
		}
		if (index1 < listQ.size() - 1) {
			index1 = index1 + 1;
			model.addAttribute("index", index1);
			model.addAttribute("userresult", userresult);
			URI = "redirect:/QuestionAnswer";
		} else {
			model.addAttribute("userresult", userresult);
			URI = "redirect:/result";

		}

		return URI;
	}

	@RequestMapping(value = "/QuestionAnswer", method = RequestMethod.GET)
	public ModelAndView showquestion(ModelAndView modelandview, @ModelAttribute("index") int index) {
		List<Questions> listQ = questionrrepository.getQuestionAnswer();

		modelandview.addObject("quest", listQ.get(index));
		modelandview.addObject("questionobj", listQ.get(index));
		modelandview.addObject("userresult", userresult);
		modelandview.setViewName("questionhome");

		return modelandview;
	}

	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView showresult(ModelAndView modelandview) {
     resultrepository.saveresult(userresult);
		modelandview.addObject("userresult", userresult);
		modelandview.setViewName("result");
		return modelandview;
	}

}
