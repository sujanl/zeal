package com.maggots.zeal.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggots.zeal.Repositoy.LoginRepository;
import com.maggots.zeal.Repositoy.UserRepository;
import com.maggots.zeal.model.Login;
import com.maggots.zeal.model.User;
import com.maggots.zeal.request.LogOutRequest;
import com.maggots.zeal.request.LoginRequest;
import com.maggots.zeal.response.LoginResponse;
import com.maggots.zeal.utils.LoginStatus;
import com.maggots.zeal.utils.UserStatus;


@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	LoginRepository loginRepository;
	
	/**
	 * 
	 * @param loginRequest
	 * @return loginId
	 */
	public Long checkLogin(LoginRequest loginRequest) {
		User user = userRepository.findByUsernameOrEmailAndStatusNot
				(loginRequest.getUsernameOrEmail(),loginRequest.getUsernameOrEmail(),UserStatus.SUSPENDED);
//		throw exception that user email or username not found if user null
		Login login = loginRepository.findByIdAndPassword(user.getLoginId(), loginRequest.getPassword());
//		throw password not match error if login null
		login.setModifiedDate(new Date());
		login.setStatus(LoginStatus.LOGGEDIN);
		login.setToken("new token");
		
		login = loginRepository.save(login);
		
		return login.getId();
	
	}

	public void logOut(Long loginId, LogOutRequest logOutRequest) {
		Login login = loginRepository.findByIdAndTokenAndStatus(loginId, logOutRequest.getToken(), LoginStatus.LOGGEDIN);
		
		login.setStatus(LoginStatus.LOGOUT);
		login.setToken("");
		
		loginRepository.save(login);
	}
}
