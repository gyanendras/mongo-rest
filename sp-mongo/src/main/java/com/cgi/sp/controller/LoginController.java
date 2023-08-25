package com.cgi.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.sp.domain.User;
import com.cgi.sp.repositories.UserRepository;

@RestController
public class LoginController {
	@Autowired
	UserRepository ur;

	@GetMapping("/signup")
	String loginForm() {
		return "Sign up pls";
	}

	@PostMapping("/register")
	void register(@RequestBody User user) {
		ur.save(user);// redirect to login then generate token, and return it.
		
		
	}
}
