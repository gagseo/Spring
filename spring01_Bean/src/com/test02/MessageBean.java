package com.test02;

public class MessageBean {

	private String fruit;
	private int cost;

	public MessageBean() {
		this.fruit = "banana";
		this.cost = 5000;
		System.out.println("기본 생성자 호출");
		
	}

	public MessageBean(String fruit, int cost) {
		super();
		this.fruit = fruit;
		this.cost = cost;
		System.out.println("매개변수가 있는 생성자 호출");
	}

	@Override
	public String toString() {
		return "MessageBean [fruit=" + fruit + ", cost=" + cost + "]";
	}

}
