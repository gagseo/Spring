package com.pattern.builder;

public class Run {

	public static void main(String[] args) {

		// Book book = new Book(); << 오류가 난다.
		// private로 선언했기 때문에 불러올수 없다.

		// 생성자를 선언한 것이 아니다.
		// new Book.BookBuilder()라는 하나의 표현식이다.
		Book book = new Book.BookBuilder().title("aaa").author("aaa").publisher("aaa").page(10000).build();
		// 객체를 생성하고 나면 수정이 안된다!
		
		
		
		
		System.out.println(book);

		
	}

}
