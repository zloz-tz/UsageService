/**
 * 
 */
package com.MapsProject.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MapsProject.classes.User;

/**
 * @author Tomer Zloczower
 * MongoDB Repository for users.
 */

@Repository
public interface UserRepository extends MongoRepository <User, String>{
	
	public User findbyKey(String key);
	//public List<User> find(ObjectId _id);

}
