/**
 * 
 */
package com.opencodez.rest.dao;

import java.util.Map;

import com.opencodez.rest.model.User;

/**
 * @author pavan.solapure
 *
 */
public interface UserService {
	
	public void addUser(User u);

	public void deleteUser(String id);

	public void updateUser(User u);

	public User getUser(String id);
	
	public Map<String, User> getMapOfUser();
}
