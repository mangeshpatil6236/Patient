package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.AgeNotFound;
import com.example.demo.Exception.DateNotFound;
import com.example.demo.Exception.IdNotFound;
import com.example.demo.Exception.NameNotFound;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;

	@Override
	public void add(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public List<Patient> display() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	@Override
	public Patient update(Integer id, Patient p) {
		// TODO Auto-generated method stub
		p.setId(id);
		return pr.save(p);
	}

//	@Override
//	public Patient searchById(Integer id) {
//		// TODO Auto-generated method stub
//		return pr.findById(id).get();
//	}

	@Override
	public Patient searchById(Integer id) {
		// TODO Auto-generated method stub
		if (!pr.existsById(id)) {
			throw new IdNotFound("ID NOT FOUND !!");
		}
		return pr.findById(id).get();

	}

//	@Override
//	public Patient searchByName(String name) {
//		// TODO Auto-generated method stub
//		return pr.findByName(name);
//	}

	@Override
	public Patient searchByName(String name) {
		// TODO Auto-generated method stub
		if (!pr.existsByName(name)) {
			throw new NameNotFound("NAME NOT FOUND !!");
		}
		return pr.findByName(name);
	}

//	@Override
//	public Patient searchByDate(String date) {
//		// TODO Auto-generated method stub
//		return pr.findByDate(date);
//	}

	@Override
	public Patient searchByDate(String date) {
		// TODO Auto-generated method stub
		if (!pr.existsByDate(date)) {
			throw new DateNotFound("DATE NOT FOUND !!");
		}
		return pr.findByDate(date);
	}

//	@Override
//	public Patient searchByAge(Integer age) {
//		// TODO Auto-generated method stub
//		return pr.searchByAge(age);
//	}

	@Override
	public Patient searchByAge(Integer age) {
		// TODO Auto-generated method stub
		if (!pr.existsByAge(age)) {
			throw new AgeNotFound("AGE NOT FOUND !!");
		}
		return pr.searchByAge(age);
	}

	@Override
	public List<Patient> searchByGender(String gender) {
		// TODO Auto-generated method stub
		return pr.searchByGender(gender);
	}

	@Override
	public List<Patient> sortByName() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();

		Collections.sort(list, new Comparator<Patient>() {

			@Override
			public int compare(Patient o1, Patient o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return list;
	}

	@Override
	public List<Patient> sortByAge() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();
		
		Collections.sort(list, new Comparator<Patient>() {
			
			@Override
			public int compare(Patient o1, Patient o2) {
				return o1.getAge().compareTo(o2.getAge());
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByEmail() {
		// TODO Auto-generated method stub
		List<Patient>list = pr.findAll();
		
		Collections.sort(list, new Comparator<Patient>() {
			
			public int compare(Patient p1, Patient p2) {
				return p1.getEmail().compareTo(p2.getEmail());
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByDate() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();
		
		Collections.sort(list, new Comparator<Patient>() {
			
			public int compare(Patient p1, Patient p2) {
				return p1.getDate().compareTo(p2.getDate());
			}
		});
		return list;
	}
	
	

}
