/**
 * 
 */
package com.MapsProject.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MapsProject.classes.User;
import com.MapsProject.services.UserService;

/**
 * @author Tomer Zloczower
 *	User Controller - insert, update, delete rest methods and filter users 
 */

@RestController
public class UserController {

	@Autowired 
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers()
	{
		return userService.retrieveUsers();
	}
	
	@GetMapping("/getUserByKey")
	public User getUserByKey (@PathParam("key") String key)
	{
		User user = userService.retrieveByKey(key);
		return user;
	}
	 
	@GetMapping("/createUser")
	public User createUser(@PathParam("key") String key, @PathParam("requests") int requestsLeft) {
		User user = userService.create(key, requestsLeft);
		return user;
	}
	
	@GetMapping("/updateUser")
	public User updateUser(@PathParam("key") String key,@PathParam ("requests") int requestsLeft)
	{
		User user = userService.update(key, requestsLeft);
		return user;
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@PathParam("key") String key)
	{
		userService.deleteByKey(key);
		return "User with key: " + key + " was deleted";
	}
	
	@GetMapping("/deleteAllUsers")
	public String deleteAllUsers()
	{
		userService.deleteAll();
		return "All records were deleted";
	}
	
	
}
