package com.edu.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



public class Triangle extends Shape{

	
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void viewSize() {
		
		System.out.println(getTitle() +"의 넓이: "+ (getHeight()*getWidth())/2);
	
	}

}
