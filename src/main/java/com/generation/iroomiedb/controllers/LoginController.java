package com.generation.iroomiedb.controllers;

import java.rmi.ServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.iroomiedb.models.Token;
import com.generation.iroomiedb.models.User;
import com.generation.iroomiedb.services.UserService;
import com.generation.iroomiedbjwt.config.JwtFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.Date;



@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin(origins="*")
public class LoginController {
	private final UserService userService;
	@Autowired
	public LoginController(UserService userService) {
		this.userService = userService;
	}//constructor
	@PostMapping
	public Token Login(@RequestBody User user) throws ServerException {
		
		if (userService.login(user.getUsername(), user.getPassword())) {
			return new Token(generateToken(user.getUsername()));
		}// if 
		throw new ServerException("Nombre de usuario o contraseña incorrectos");
	} // Login
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}// generateToken

	
	
}//class UserController