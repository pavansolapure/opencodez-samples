/**
 * 
 */
package com.opencodez.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opencodez.rest.dao.UserService;
import com.opencodez.rest.model.User;

/**
 * @author pavan.solapure
 *
 */

@RestController
public class MainController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/list", method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		List<User> users = new ArrayList<User>(userService.getMapOfUser().values());
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE})
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/users/get/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable(value = "userid") String userid) {
		User usr = userService.getUser(userid);
		if (usr == null) {
			return new ResponseEntity("User with id " + userid + " not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(usr, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/users/delete/{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable(value = "userid") String userid) {
		User usr = userService.getUser(userid);
		if (usr == null) {
			return new ResponseEntity("User with id " + userid + " not found", HttpStatus.NOT_FOUND);
		}
		userService.deleteUser(usr.getId());
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
