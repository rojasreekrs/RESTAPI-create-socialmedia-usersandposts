package com.learnspringboot.rest.webservices.restful_web_services.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.learnspringboot.rest.webservices.restful_web_services.bean.User;

@Component
public class UserDaoService {
	
	//create list of users
	private static List<User> users = new ArrayList<>();
	
	public static int userCount = 0;
	
	//add users info
	//when static is declared everytime we compile it starts with 3 users bcoz we created 3 users in static block
	static {
		users.add(new User(++userCount,"Roja",LocalDate.now().minusYears(25)));
		users.add(new User(++userCount,"Sriv",LocalDate.now().minusYears(30)));
		users.add(new User(++userCount,"Sanju",LocalDate.now().minusYears(26)));
	}
	
	//display all users
	public List<User> findAll(){
		return users;
	}
	
	//display specific user
	public User findUser(int id) {
		//functional programming
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	//create a user
	public User createUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteUser(int id) {
		
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.remove(predicate);
	}
}