package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	private UserService us;

	UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("adduser")
	public void add(@RequestBody User u) {
		us.add(u);
	}

	@GetMapping("displayuser")
	public List<User> display() {
		return us.display();
	}

	@DeleteMapping("deleteuser = {id}")
	public void deleteUser(@PathVariable Integer id) {
		us.delete(id);
	}

	@PutMapping("updateuser = {id}")
	public User update(@PathVariable Integer id, @RequestBody User u) {
		return us.update(id, u);
	}

	@GetMapping("user/page")
	public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Sort sort=Sort.by("name").descending();
		Pageable of = PageRequest.of(page, size,sort);
		return this.userRepository.findAll(of);
	}
	
	
//	@GetMapping("user/page")
//	public Page<User> getAllUsers(@RequestParam(defaultValue = "0") int page,
////			@RequestParam(defaultValue = "5", @RequestParam(defaultValue = "name")String sortBy, @RequestParam(defaultValue = "asc") String order){
//		Sort sort = order.equalsIgnoreCase(order) ?
//				Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
//		Pageable of = PageRequest.of(page, size, order);
//		return this.userRepository.findAll(of);
//	}
}
