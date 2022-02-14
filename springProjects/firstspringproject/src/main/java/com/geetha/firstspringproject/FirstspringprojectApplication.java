package com.geetha.firstspringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class FirstspringprojectApplication {
        public static void main(String[] args) {
                SpringApplication.run(FirstspringprojectApplication.class, args);
        }
        
//        // 1. Annotation
//        @RequestMapping("/")
//        // 3. Method that maps to the request route above
//        public String hello() { // 3
//                return "Hello World!";
//        }
//        
        @RequestMapping("/first_route")
        // 3. Method that maps to the request route above
        public String first() { // 3
                return "This is my first route in spring";
        }
}