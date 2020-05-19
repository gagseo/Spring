package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		// ApplicationContext dao 역할
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/beans.xml");

		//DL(Dependency LookUp : 의존객체검색)
		// 캐스팅
		MessageBeanEn beanEn = (MessageBeanEn) factory.getBean("english"); // object타입으로 반환되므로 캐스팅
		MessageBeanKo beanKo = (MessageBeanKo) factory.getBean("korean");

		beanEn.sayHello("마이클");
		System.out.println(System.identityHashCode(beanEn));
		beanKo.sayHello("김덕배");
		System.out.println(System.identityHashCode(beanKo));
		MessageBeanEn beanEn2 = (MessageBeanEn) factory.getBean("english"); // object타입으로 반환되므로 캐스팅
		MessageBeanKo beanKo2 = (MessageBeanKo) factory.getBean("korean");

		beanEn2.sayHello("오렌지");
		System.out.println(System.identityHashCode(beanEn2));
		beanKo2.sayHello("쥬스");
		System.out.println(System.identityHashCode(beanKo2));

		// 주소가 같다.
		// 컨테이너에 등록된 bean은 재 선언되더라도 같은 주소값을 가진다
		// 주소가 같은 이유는 객체 생성이 아니라 기존에 만들어진 객체 주소에 재 할당된다.
	}

}
