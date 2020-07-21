package com.cts.ims.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ims.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
 User findById(int id); 

}
