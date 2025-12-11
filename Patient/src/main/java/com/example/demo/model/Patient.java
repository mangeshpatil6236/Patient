package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {

	@Id
	private int id;
	private String name;
	private int age;
	private String gender;
	private String mobile;
	private String email;
	private String address;
	private String date;
	
	
}
