package com.geetha.daikichiroutes.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class AppController {
	
	@RequestMapping("")
    public String welcome() {
            return "Welcome to Daikichi Fortune";
    }
	
	@RequestMapping("/today")
    public String todaysFortune() {
            return "Today you will find luck in all your endeavors!";
    }
	
	@RequestMapping("/tomorrow")
    public String tomorrowsFortune() {
            return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }
	
	@RequestMapping("/travel/{city}")
    public String travelFortune(@PathVariable("city") String city) {
            return "Congratulations! You will soon travel to "+city+"!.";
    }
	
	@RequestMapping("/lotto/{num}")
    public String oddEvenFortune(@PathVariable("num")int num) {
		if(num %2 ==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
            
    }
	
	

}
