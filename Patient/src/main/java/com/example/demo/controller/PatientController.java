package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService ps;

	@PostMapping("add")
	public void add(@RequestBody Patient p) {
		ps.add(p);
	}

	@GetMapping("display")
	public List<Patient> display() {
		return ps.display();
	}

	@DeleteMapping("delete = {id}")
	public void delete(@PathVariable Integer id) {
		ps.delete(id);
	}

	@PutMapping("update = {id}")
	public Patient update(@PathVariable Integer id, @RequestBody Patient p) {
		return ps.update(id, p);
	}

	@PostMapping("searchbyid = {id}")
	public ResponseEntity<?> searchById(@PathVariable Integer id) {
		Patient result = ps.searchById(id);
		return new ResponseEntity<Patient>(result, HttpStatus.OK);
	}

	@PostMapping("searchbyname = {name}")
	public ResponseEntity<?> searchByName(@PathVariable String name) {
		Patient result = ps.searchByName(name);
		return new ResponseEntity<Patient>(result, HttpStatus.OK);
	}

	@PostMapping("searchbydate = {date}")
	public ResponseEntity<?> searchByDate(@PathVariable String date) {
		Patient result = ps.searchByDate(date);
		return new ResponseEntity<Patient>(result, HttpStatus.OK);
	}

	@PostMapping("searchbyage = {age}")
	public ResponseEntity<?> searchByAge(@PathVariable Integer age) {
		Patient result = ps.searchByAge(age);
		return new ResponseEntity<Patient>(result, HttpStatus.OK);
	}

	@PostMapping("searchbygender = {gender}")
	public List<Patient> searchByGender(@PathVariable String gender) {
		return ps.searchByGender(gender);
	}
	
	
	@PostMapping("sortbyname")
	public List<Patient> sortByName(){
		return ps.sortByName();
	}
	
	@PostMapping("sortByAge")
	public List<Patient> sortByAge(){
		return ps.sortByAge();
	}
	
	@PostMapping("sortbyemail")
	public List<Patient> sortByEmail(){
		return ps.sortByEmail();
	}
	
	@PostMapping("sortbydate")
	public List<Patient> sortByDate(){
		return ps.sortByDate();
	}
	
	
	
	
	
	
	
	
	
	
	
	

//	@GetMapping("searchbyid = {id}")
//	public Patient searchById(@PathVariable Integer id) {
//		return ps.searchById(id);
//	}

//	@PostMapping("searchbyname = {name}")
//	public Patient searchByName(@PathVariable String name) {
//		return ps.searchByName(name);
//	}

//	@PostMapping("searchbydate = {date}")
//	public Patient searchByDate(@PathVariable String date) {
//		return ps.searchByDate(date);
//	}

//	@PostMapping("searchbyage = {age}")
//	public Patient searchByAge(@PathVariable Integer age) {
//		return ps.searchByAge(age);
//	}
}
