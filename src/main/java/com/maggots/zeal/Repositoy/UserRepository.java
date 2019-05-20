package com.maggots.zeal.Repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maggots.zeal.model.User;
import com.maggots.zeal.utils.UserStatus;
@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
	/**
	 * find a user with his/her id
	 * @param userId
	 * @return user
	 */
	User getById(Long userId);
	
	/**
	 * find a non-suspended user by username 0r email
	 * @param usernameOrEmail
	 * @param usernameOrEmail
	 * @param suspended
	 * @return user
	 */
	User findByUsernameOrEmailAndStatusNot(String usernameOrEmail, String usernameOrEmail2, UserStatus suspended);

}
