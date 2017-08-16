package com.data;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public  interface userRepository {

	public void saveUser(User user);
	
	public User finduser(String name);
	
}
