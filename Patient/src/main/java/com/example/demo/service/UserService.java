package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	void add(User u);

	List<User> display();

	 
	User update(Integer id, User u);

	void delete(Integer id);

}
