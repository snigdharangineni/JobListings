package com.springboot.joblisting.respository;


import com.springboot.joblisting.model.User;

public interface UserRepository{

	public User findByUserName(String userName);
}
