package com.test03;

public class Address {

	private String name;
	private String add;
	private String phone;

	public Address() {
		System.out.println("기본 생성자 호출");
	}

	public Address(String name, String add, String phone) {
		super();
		this.name = name;
		this.add = add;
		this.phone = phone;
		System.out.println("매개변수가 있는 생성자 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name + "값이 입력되었습니다.");
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
		System.out.println(add + "값이 입력되었습니다.");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println(phone + "값이 입력되었습니다.");
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", add=" + add + ", phone=" + phone + "]";
	}

}
