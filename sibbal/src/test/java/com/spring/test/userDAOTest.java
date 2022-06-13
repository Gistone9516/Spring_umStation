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

//Runner Ŭ����(�׽�Ʈ �޼ҵ带 �����ϴ� Ŭ����) �� SpringJUnit4ClassRunner�� ��
@RunWith(SpringJUnit4ClassRunner.class)
//location �Ӽ� ��ο� �ִ� xml ������ �̿��ؼ� �������� �ε���
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")

public class userDAOTest {
	//DAO �� ������ ��ü �ڵ����� ����
	@Inject
	private userDAO dao;
	
	@Before //@Test ���� ����
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