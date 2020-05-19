package com.ioc.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.ioc.library.dao.MemberDao;
import com.ioc.library.vo.Member;

public class Run {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);

		// MemberDao mDao = new MemberDao();
		// mDao.setConnectionMaker(new ClientConnectionMaker());
		// 위 코드와 아래코드는 같은 코드이다.
		MemberDao mDao = new DaoFactory().createMemberDao();

		Member member = new Member();

		System.out.println("아이디를 입력하세요 : ");
		member.setId(sc.nextLine());
		System.out.println("비밀번호를 입력하세요 : ");
		member.setPassword(sc.nextLine());
		System.out.println("이메일를 입력하세요 : ");
		member.setE_mail(sc.nextLine());

		mDao.insertMember(member);
		Member res = mDao.selectMember(member.getId());

		System.out.println(res);

	}

}
