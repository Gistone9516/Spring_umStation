package com.spring.test;

import java.util.Date;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.test.domain.userVO;
import com.spring.test.persistence.userDAO;

//Runner 클래스(테스트 메소드를 실행하는 클래스) 를 SpringJUnit4ClassRunner로 함
@RunWith(SpringJUnit4ClassRunner.class)
//location 속성 경로에 있는 xml 파일을 이용해서 스프링이 로딩됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class userDAOTest {
	//DAO 를 구현한 객체 자동으로 생성
	@Inject
	private userDAO dao;
	
	@Before //@Test 전에 실행
	public void testInsertMember() throws Exception{
		userVO vo = new userVO();
		vo.setuser_id("gaga");
		vo.setuser_pw("1234");
		vo.setuser_name("koo");
		vo.setuser_hp("01090510994");
		//vo.setuser_birth(new Date(System.currentTimeMillis()));
		
		
		dao.insertUser(vo);
	}
	@Test
	public void testSelectMember() throws Exception{
		userVO vo = dao.selectUser("gaga");
		System.out.println(vo.getuser_id()+"/"+vo.getuser_pw());
	}
	
}