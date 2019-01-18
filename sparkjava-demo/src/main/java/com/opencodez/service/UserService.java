package com.opencodez.service;

import java.util.List;

import com.opencodez.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public void editUser(User user);
	
	public User getUserById(String id);
	
	public void deleteUserById(String id);
	
	public List<User> getUsers();
}
