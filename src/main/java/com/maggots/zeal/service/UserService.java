package com.maggots.zeal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggots.zeal.Repositoy.LoginRepository;
import com.maggots.zeal.Repositoy.UserRepository;
import com.maggots.zeal.model.Login;
import com.maggots.zeal.model.User;
import com.maggots.zeal.request.UserSignupRequest;
import com.maggots.zeal.request.UserUpdateRequest;
import com.maggots.zeal.response.UserResponse;
import com.maggots.zeal.utils.LoginStatus;
import com.maggots.zeal.utils.UserStatus;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	
	public Long addUser(UserSignupRequest userDto) {
		User user = new User();	 	

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setCreatedDate(new Date());
		user.setDob(userDto.getDob());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setStatus(UserStatus.ACTIVE);
		
		Login login = new Login();
		login.setCreatedDate(new Date());
		login.setPassword(userDto.getPassword());
		login.setStatus(LoginStatus.LOGOUT);
		login.setToken("token");
		login = loginRepository.save(login);	
		user.setLoginId(login.getId());
		
		userRepository.save(user);
		return user.getId();
	}
	public UserResponse getUser(Long userId) {
		User user=userRepository.getById(userId);
		
		UserResponse response=new UserResponse();
		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setUsername(user.getUsername());
		response.setEmail(user.getEmail());
		
		return response;
	}
	public void updateUser(UserUpdateRequest userDto, Long userId) {
		User user=userRepository.getById(userId);
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		userRepository.save(user);
		
	}
	public void deleteUser(Long id) {
		User user=userRepository.getById(id);
//		if(user==null)
		user.setStatus(UserStatus.DELETED);
		userRepository.save(user);
		
	}
	public Map<Object, Object> getAllUser() {
		List<User> user = userRepository.findAll();
		List<UserResponse> userResponse = new ArrayList<>();
		for(User ur:user) {
			UserResponse response=new UserResponse();
            response.setId(ur.getId());
			response.setFirstName(ur.getFirstName());
			response.setLastName(ur.getLastName());
			response.setEmail(ur.getEmail());
			response.setUsername(ur.getUsername());
			
			userResponse.add(response);
		}
		Map<Object, Object> responseMap = new HashMap<Object, Object>();
		responseMap.put("All Users", userResponse);
		return responseMap;
	}
	
	
}
