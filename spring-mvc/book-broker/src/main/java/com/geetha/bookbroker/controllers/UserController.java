package com.geetha.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.geetha.bookbroker.models.Book;
import com.geetha.bookbroker.models.LoginUser;
import com.geetha.bookbroker.models.User;
import com.geetha.bookbroker.service.BookService;
import com.geetha.bookbroker.service.UserService;

@Controller
public class UserController {
	// Add once service is implemented:
	@Autowired
	private UserService userService;

    @Autowired
    private BookService bookService; 

	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		userService.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", newUser.getId());
		session.setAttribute("userName", newUser.getUserName());
		return "redirect:/dashboard";

	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getUserName());
		return "redirect:/dashboard";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Book> allBooks=bookService.findAllBooks();
		model.addAttribute("allBooks", allBooks);
		List<Book> availableBooks= bookService.findAvailableBooks();
		model.addAttribute("availableBooks", availableBooks);
		return "dashboard.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}