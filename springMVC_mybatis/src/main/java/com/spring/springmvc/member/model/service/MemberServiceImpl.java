package com.spring.springmvc.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.spring.springmvc.member.model.dao.MemberDao;
import com.spring.springmvc.member.model.vo.Member;

@Service
//scope : 빈의 생명주기를 결정
//	// singleton : singleton 스코프
// 	// requset : requset 스코프
//  // session : session 스코프
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao mDao;

	@Autowired
	JavaMailSender mailSender;

	public String idCheck(String id) {

		return mDao.idCheck(id);
	}

	// @Transactional
	// @Transactional(rollbackFor = Exception.class)
	public int insertMember(Map<String, Object> commandMap) throws SQLException {

		int res = mDao.insertMember(commandMap);

		// 트랜잭션 테스트를 위한 에러코드

		// runtimeException
		// String str = null;
		// str.length();
		// 롤백확인

		// CheckedException
		// throw new SQLException();

		return res;

	}

	public Member login(Map<String, Object> commandMap) {

		return mDao.login(commandMap);
	}

	public void mailSending(Map<String, Object> commandMap) {

		// 발신자메일
		String from = "gagseo@naver.com";
		String tomail = (String) commandMap.get("m_email");
		String title = "가입을 환영합니다.";
		String htmlBody = "<form action='http://" + commandMap.get("urlPath")
				+ "/member/joinimple.do' method='post'><h3>회원가입을 환영합니다.</h3>" + "<input type='hidden' value='"
				+ commandMap.get("userId") + "' name='userId'>" + "<input type='hidden' value='"
				+ commandMap.get("userPwd") + "' name='userPwd'>" + "<input type='hidden' value='"
				+ commandMap.get("m_email") + "' name='m_email'>" + "<input type='hidden' value='"
				+ commandMap.get("m_tell") + "' name='m_tell'>" + "<button type='submit'>가입하기</form>";

		// 메일 발송해주는 코드
		// Template CallBack 패턴
		// 장점 : 빈에 등록을 안해도 된다.
		// 전략패턴과 동일한 용도로 사용되는 디자인 패턴 > 주입되는 객체가 내부 익명클래스 이다.
		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom(from);
				message.setTo(tomail);
				message.setSubject(title);
				message.setText(htmlBody, true);
				// message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
				// message.addAttachment("myDocument.pdf", new
				// ClassPathResource("doc/myDocument.pdf"));
			}
		});

	}

}
