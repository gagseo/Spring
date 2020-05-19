package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");
		
		Address lee = (Address) factory.getBean("lee");
		System.out.println(lee);
		Address hong = (Address) factory.getBean("hong");
		System.out.println(hong);
		
	}

}
