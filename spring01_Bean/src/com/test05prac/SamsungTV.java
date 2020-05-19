package com.test05prac;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("SamsungTV 생성");

	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV Off");

	}

	@Override
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");

	}

}
