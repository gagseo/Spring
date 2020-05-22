package com.test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		System.out.println("출석카드를 찍는다.");
		try {
//			모든 메서드에 대해서 여기서 실행된다.
//			해당 메서드의 리턴값이 있다면 target에 담긴다.
			target = invocation.proceed();
			System.out.println(target);
		} catch(Throwable e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에간다.");
		}
		
		return target;
	}

}
