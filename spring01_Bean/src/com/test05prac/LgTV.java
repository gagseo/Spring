package com.test05prac;

public class LgTV implements TV {

	public LgTV() {
		System.out.println("LgTV 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV On");

	}

	@Override
	public void powerOff() {
		System.out.println("LgTV Off");

	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV volumeDown");

	}

	
	

}
