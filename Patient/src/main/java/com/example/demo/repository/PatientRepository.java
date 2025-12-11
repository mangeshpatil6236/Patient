package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Patient findByName(String name);

	Patient findByDate(String date);

	Patient searchByAge(Integer age);

	boolean existsByAge(Integer age);

	boolean existsByName(String name);

	boolean existsByDate(String date);

	List<Patient> searchByGender(String gender);

}
