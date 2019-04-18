package com.MapsProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MapsProject.classes.User;
import com.MapsProject.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(String key, int requests) {
		return userRepository.save(new User(key, requests));
	}

	public List<User> retrieveUsers() {
		return userRepository.findAll();
	}
	
	public User retrieveByKey(String key) {
		return userRepository.findbyKey(key);
	}
	
	public User update(String key, int requestsLeft)
	{
		User user = userRepository.findbyKey(key);
		user.setRequestsLeft(requestsLeft);
		return userRepository.save(user);
	}
	
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	public void deleteByKey(String key) {
		User user = userRepository.findbyKey(key);
		userRepository.delete(user);
	}
}
