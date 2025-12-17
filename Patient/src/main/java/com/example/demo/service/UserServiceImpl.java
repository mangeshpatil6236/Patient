package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository ur;

	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public List<User> display() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}

	 

	@Override
	public User update(Integer id, User u) {
		// TODO Auto-generated method stub
		u.setId(id);
		return ur.save(u);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		 ur.deleteById(id);
	}

}
