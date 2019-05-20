package com.maggots.zeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maggots.zeal.model.Login;
import com.maggots.zeal.request.LogOutRequest;
import com.maggots.zeal.request.LoginRequest;
import com.maggots.zeal.service.LoginService;

/**
 * Controller for {@link Login}
 * @author ADMIN
 *
 */
@RestController
@RequestMapping("/api")
	public class LoginController {
	
		@Autowired
		LoginService loginService;
		
		@RequestMapping(value = "/login", method=RequestMethod.POST)
		public ResponseEntity<Object> login(@RequestBody LoginRequest loginDto){
			Long loginId = loginService.checkLogin(loginDto);
			return new ResponseEntity<Object>("LoginId = "+loginId, HttpStatus.OK);	
		}
		
		@RequestMapping(value = "/logout", method = RequestMethod.PUT)
		public ResponseEntity<Object> logOut(@RequestHeader Long loginId, @RequestBody LogOutRequest logOutRequest){
			loginService.logOut(loginId, logOutRequest);
			return new ResponseEntity<Object>("Logged out!", HttpStatus.OK);
		}
	}

