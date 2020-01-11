package com.capgemini.springmvc.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.capgemini.springmvc.beans.User;

@Controller
public class SpringController {
	@Autowired
	private ServletContext context;


	@RequestMapping("/hello")
	public String hello(ModelMap map) {
		map.addAttribute("msg", "Hello World..........!!!!!!");
		return "index";  // returning name of  the jsp file;
	}


	//@RequestMapping(path="/query",method=RequestMethod.GET)    //both are same
	@GetMapping("/query")
	public String query(@RequestParam(name="name")String name,@RequestParam(name="age")int age,ModelMap map)
	{
		map.addAttribute("name", name);
		map.addAttribute("age",age);

		return "query";
	}
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	@PostMapping("/form")
	public String form(User user,ModelMap map)
	{
		map.addAttribute("name",user.getName());
		map.addAttribute("email", user.getEmail());
		map.addAttribute("password",user.getPassword());
		map.addAttribute("gender",user.getGender());
		return "form";
	}


	//********************************************create cookie*******************************************************
	@GetMapping("/createcookie")
	public String createCookie(HttpServletResponse response)
	{
		Cookie cookie= new Cookie("name", "Vidya");
		response.addCookie(cookie);
		return "createcookie";
	}

	@GetMapping("/getcookie")
	public String getCookie(ModelMap map,@CookieValue(name="name",required=false)String name)
	{
		if(name!=null) {
			map.addAttribute("name",name);
		}else 
			map.addAttribute("name", "ranjana");

		return "getcookie";
	}
	//******************************************path param****************************************************************
	@GetMapping("/path/{movie}/{hero}")
	public String path(@PathVariable("movie")String movie,@PathVariable("hero")String hero,ModelMap map) {
		map.addAttribute("movie", movie);
		map.addAttribute("hero", hero);
		return "pathvalue";

	}

	@GetMapping("/forward")
	public String forward() {
		return "forward:hello"; //controllerName:hello
	}
	@GetMapping("/redirect")
	public String redirect()
	{
		return "redirect:https:/www.google.com";
	}
	//**************************************************Session**********************************************************************

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(String username,String password,HttpServletRequest request,ModelMap map)
	{
		if(username.equals("user") && password.equals("qwerty")) {
			User user= new User();
			user.setName(username);
			user.setEmail("user@gmail.com");
			user.setPassword(password);
			user.setGender("F");
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			map.addAttribute("msg","User Loged In");
			return "home";
		}
		else {
			map.addAttribute("msg","Credential Invalid");
			return "login";
		}

	}
	@GetMapping("/home")
	public String home(@SessionAttribute(name="user",required = false) User user) {
		if(user!=null) {
			return "home";

		}else {
			return "login";
		}
	}
		@GetMapping("setappattribute")
		public String setAttribute() {
			context.setAttribute("msg", new Object());
			return "setcontext";
		}
		@GetMapping("getappattribute")
		public String getAppAttribute() {
			System.out.println(context.getAttribute("msg"));
			return "getcontext";
		}


	}

