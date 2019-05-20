package com.maggots.zeal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maggots.zeal.request.UserSignupRequest;
import com.maggots.zeal.request.UserUpdateRequest;
import com.maggots.zeal.response.UserResponse;
import com.maggots.zeal.service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<Object> createUserAccount(@RequestBody UserSignupRequest userSignupRequest){
		Long userId = userService.addUser(userSignupRequest);
		return new ResponseEntity<Object>("UserId = "+userId,HttpStatus.CREATED);
	}

	@RequestMapping(value ="/{userId}/profile",method=RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable Long userId) {
		UserResponse response=userService.getUser(userId);
		return new ResponseEntity<Object>(response,HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}",method=RequestMethod.PUT)
	public ResponseEntity<Object> putUser(@RequestBody UserUpdateRequest userDto,@PathVariable Long userId){
		userService.updateUser(userDto, userId);
		return new ResponseEntity<Object>("updated",HttpStatus.OK);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Object> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<Object>("deleted",HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> listAllUser(){
		Map<Object, Object> responseMap = userService.getAllUser();
		return new ResponseEntity<Object>(responseMap, HttpStatus.OK);	
	}
}

