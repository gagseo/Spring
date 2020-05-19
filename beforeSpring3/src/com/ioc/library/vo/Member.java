package com.ioc.library.vo;

public class Member {
	
	private String id;
	private String password;
	private String e_mail;
	
	public Member() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", e_mail=" + e_mail + "]";
	}

	

}
