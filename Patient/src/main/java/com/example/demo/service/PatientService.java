package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {

	void add(Patient p);

	List<Patient> display();

	void delete(Integer id);

	Patient update(Integer id, Patient p);

	Patient searchById(Integer id);

	Patient searchByName(String name);

	Patient searchByDate(String date);

	Patient searchByAge(Integer age);

	List<Patient> searchByGender(String gender);

	List<Patient> sortByName();

	List<Patient> sortByAge();

	List<Patient> sortByEmail();

	List<Patient> sortByDate();

}
