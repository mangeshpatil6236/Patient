package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.Exception.AgeNotFound;
import com.example.demo.Exception.DateNotFound;
import com.example.demo.Exception.IdNotFound;
import com.example.demo.Exception.NameNotFound;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ IdNotFound.class })
	public ResponseEntity<?> idNotFoundHandler(IdNotFound e) {
		return ResponseEntity.status(369).body(e.getMessage());
	}

	@ExceptionHandler({ AgeNotFound.class })
	public ResponseEntity<?> ageNotFoundHandler(AgeNotFound e) {
		return ResponseEntity.status(370).body(e.getMessage());
	}

	@ExceptionHandler({ NameNotFound.class })
	public ResponseEntity<?> nameNotFoundHandler(NameNotFound e) {
		return ResponseEntity.status(371).body(e.getMessage());
	}

	@ExceptionHandler({ DateNotFound.class })
	public ResponseEntity<?> dateNotFound(DateNotFound e) {
		return ResponseEntity.status(372).body(e.getMessage());
	}
}
