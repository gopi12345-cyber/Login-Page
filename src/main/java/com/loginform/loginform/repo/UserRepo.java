package com.loginform.loginform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginform.loginform.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,String> {

	User findByUserId(String userId);

}
