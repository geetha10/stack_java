package com.geetha.hellohuman.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@RequestMapping("/hello_human")
	public String sayHello(@RequestParam(value="first_name") String first_name) {
		return "Hello " + first_name;
	}
	
	@RequestMapping("/hello_human/n_times")
	public String sayHelloNTimes(@RequestParam(value="first_name") String first_name, 
			@RequestParam(value="times") int times) {
		String returnString="";
		
		for (int i=0;i<times;i++) {
			returnString += "Hello! "+first_name+". ";
		}
		return returnString;
	}
	
	@RequestMapping("/hello_human/full_name")
	public String greetHello(@RequestParam(value="first_name") String first_name, 
			@RequestParam(value="last_name") String last_name,
			@RequestParam(value="times") int times) {
		String returnString="";
		
		for (int i=0;i<times;i++) {
			returnString += "Hello! "+first_name+" "+last_name+". ";
		}

		return returnString;
	}
	
	@RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
}
	

