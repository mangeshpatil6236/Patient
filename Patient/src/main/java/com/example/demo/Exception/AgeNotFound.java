package com.example.demo.Exception;

public class AgeNotFound extends RuntimeException{
	
	public AgeNotFound(String msg) {
		super(msg);
	}
}