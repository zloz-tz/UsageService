package com.MapsProject.classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Tomer Zloczower
 * User class - containing the usage details of the Maps Service by the user 
 */


@Document(collection = "Users")
public class User {
	 
	@Id 
	private String id;
	private String key;
	private int requestsLeft;
	private int requestsUsed;
	
	public User() {}
	
	public User(String key, int requests)
	{
		this.key = key;
		this.requestsLeft = requests;
		this.requestsUsed = 0;
	}
	
	public User(String key, int requestsLeft, int requestsUsed) {
		this.key = key;
		this.requestsLeft = requestsLeft;
		this.requestsUsed = requestsUsed;
	}

	
	public void setKey(String key) {
		this.key = key;
	}

	public void setRequestsLeft(int requestsLeft) {
		this.requestsLeft = requestsLeft;
	}

	public void setRequestsUsed(int requestsUsed) {
		this.requestsUsed = requestsUsed;
	}

	
	public String getId() {
		return id;
	}
	public String getKey() {
		return key;
	}

	public int getRequestsLeft() {
		return requestsLeft;
	}

	public int getRequestsUsed() {
		return requestsUsed;
	}

	@Override
	public String toString() {
		return "User [key=" + key + ", requestsLeft=" + requestsLeft + ", requestsUsed=" + requestsUsed + "]";
	}
	
	
	

}
