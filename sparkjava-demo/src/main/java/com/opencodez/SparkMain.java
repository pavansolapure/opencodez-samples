/**
 * 
 */
package com.opencodez;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.put;
import static spark.Spark.post;

import com.google.gson.Gson;
import com.opencodez.domain.User;
import com.opencodez.service.UserService;
import com.opencodez.service.UserServiceImpl;

public class SparkMain {
	
	public static void main(String[] args) {

		final UserService userService = new UserServiceImpl();
		
		//configure port
		port(8080);
		
		get("/hello", (req, res)->"Hello, world!");
		
		get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name") + "!!";
        });
		
		post("/users/add", (req,res)-> {
			res.type("application/json");
			
			User user = new Gson().fromJson(req.body(), User.class);
            userService.addUser(user);

            return new Gson().toJson(user);
        });
		
		get("/users", (req,res)-> {
			res.type("application/json");
			return new Gson().toJson(userService.getUsers());
        });
		
		delete("/users/delete/:id", (req,res) -> {
			res.type("application/json");
		    userService.deleteUserById(req.params(":id"));
		    return new Gson().toJson("User deleted");
		});
		
		put("/users/edit/:id", (req,res) -> {
			res.type("application/json");
		    User ue = new Gson().fromJson(req.body(), User.class);
		    
		    User searchedUser = userService.getUserById(ue.getId());
		    if(searchedUser != null) {
		    	userService.editUser(ue);
		    	return new Gson().toJson(ue);
		    } else {
		    	return new Gson().toJson("User not found or error in edit");
		    }
		    
		});
		
	}
}
