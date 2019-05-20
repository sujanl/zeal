package com.maggots.zeal.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maggots.zeal.model.Login;
import com.maggots.zeal.utils.LoginStatus;

public interface LoginRepository extends JpaRepository<Login, Long>{
	
	/**
	 * find login of a user using his/her login id and password
	 * @param loginId
	 * @param password
	 * @return
	 */
	Login findByIdAndPassword(Long loginId, String password);
	 /**
	  * find logged in login information with loginid & token
	  * @param loginId
	  * @param token
	  * @param loggedStatus
	  * @return login
	  */
	Login findByIdAndTokenAndStatus(Long loginId, String token, LoginStatus loggedin);

}
