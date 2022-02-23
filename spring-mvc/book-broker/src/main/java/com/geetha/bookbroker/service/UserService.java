package com.geetha.bookbroker.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.geetha.bookbroker.models.LoginUser;
import com.geetha.bookbroker.models.User;
import com.geetha.bookbroker.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		//TO DO Additional validations
		
		 // 1.  Find user in the DB by email
		Optional<User> potentialUser=userRepository.findByEmail(newUser.getEmail());
		
		// 2. check email. if it is present, reject 
		if(potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "User Already Exists");
		}
		
		// 3. check newUser password != newUser confirm, reject
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Password and Confirm Password doesn't match");
		}
		// 4. if result has errors , return null
		if(result.hasErrors()) {
    		return null;
    	}
		
		 // 5. Hash and set password, save user to database
		String hasedPassword=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hasedPassword);
		
		return userRepository.save(newUser);
		
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		//TO DO Additional validations
		
		// 1. Find user in the DB by email
		Optional<User> potentialUser=userRepository.findByEmail(newLogin.getEmail());
		
		// 2. check email.. if it is NOT present, reject 
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "NotPresent", "Email is not registered with us.");
			return null;
		}
		
		// 3.1 grab the user from db
		
		User user=potentialUser.get();	
		
		// 3.2 Check password with BCrypt --> failed --> reject
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		
		 // 4. if result has errors, return null
		if(result.hasErrors()) {
			return null;
		}
		
		// 5. NO ERRORS --> return the user object
		return user;
		
	}
	
	public User getUserById(Long id) {
		Optional<User> loggedInUser= userRepository.findById(id);
		if(loggedInUser.isPresent()) {
			return loggedInUser.get();
		}
		return null;
				
	}
}
