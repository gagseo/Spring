package com.pattern.builder;

// 점층적 생성자 패턴
// 단점 : 뭐가 뭔지 모르겠다.

//====================================================
// 자바 빈 규약에 따른 방식
// 1) 기본생성자가 있어야한다.
// 2) 필드 변수는 private 이여야 한다.
// 3) getter/setter 를 지원
// 4) 직렬화가 되어있어야 한다.
// 단점 : 객체 일관성이 깨진다.
//  // 처음 객체를 생성할 때의 상태가 바뀔 수 있다.
//  // setter의 존재 때문에 변경 불가능(immutable) 클래스를 만들 수 없다.
//====================================================


public class Book {

	// 반드시 필요한 필수인자 라고 정함
	// private final int B_ISBN;

	// 선택적 인자
	private String title;
	private String author;
	private String publisher;
	private int page;

	// 이너클래스
	public static class BookBuilder {
		// 사용자로부터 매개변수를 받아서 자신의 필드 변수에 저장한뒤 반환해준다.
		private String title;
		private String author;
		private String publisher;
		private int page;

		public BookBuilder title(String val) {
			title = val;

			// 자기 자신을 반환해주는
			return this;

		}

		public BookBuilder author(String val) {
			author = val;

			// 자기 자신을 반환해주는
			return this;

		}

		public BookBuilder publisher(String val) {
			publisher = val;

			// 자기 자신을 반환해주는
			return this;

		}

		public BookBuilder page(int val) {
			page = val;

			// 자기 자신을 반환해주는
			return this;

		}

		public Book build() {
			return new Book(this);

		}

	}

	// private로 선언
	private Book(BookBuilder builder) {

		title = builder.title;
		author = builder.author;
		publisher = builder.publisher;
		page = builder.page;

	}

	@Override
	public String toString() {
		return "BookBuilder [title=" + title + ", author=" + author + ", publisher=" + publisher + ", page=" + page
				+ "]";
	}

}
