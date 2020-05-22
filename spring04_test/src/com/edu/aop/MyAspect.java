package com.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class MyAspect {

	public void before(JoinPoint join) {
		
		System.out.println("도형의 넓이를 구한다.");
	}


	public void after(JoinPoint join) {
		System.out.println("도형의 넓이를 출력한다.");
	}


}
