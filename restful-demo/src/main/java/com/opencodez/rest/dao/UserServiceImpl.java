/**
 * 
 */
package com.opencodez.rest.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.opencodez.rest.model.User;

/**
 * @author pavan.solapure
 *
 */
@Repository
public class UserServiceImpl implements UserService {

	private Map<String, User> mapOfUser = new HashMap<String, User>();

	public void addUser(User u) {
		mapOfUser.put(u.getId(), u);
	}

	public void deleteUser(String id) {
		mapOfUser.remove(id);
	}

	public void updateUser(User u) {
		mapOfUser.replace(u.getId(), u);
	}

	public User getUser(String id) {
		return mapOfUser.get(id);
	}

	public Map<String, User> getMapOfUser() {
		return mapOfUser;
	}

}
