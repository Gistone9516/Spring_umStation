package com.spring.test.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.test.domain.rental_umVO;
import com.spring.test.domain.userVO;

@Repository //DAO를 스프링에 인식시키기 위해서 사용
public class userDAOImpl implements userDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String GetTime = "UserMapper.getTime";
	private static final String InsertUser = "UserMapper.insertUser";
	private static final String UpdateUserRental = "UserMapper.updateUserRental";
	private static final String SelectUser = "UserMapper.selectUser";
	private static final String SelectID = "UserMapper.selectID";
	private static final String SelectIDstate = "UserMapper.selectIDstate";
	private static final String ExistID = "UserMapper.existID";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
		
	}
	@Override
	public void insertUser(userVO vo) {
		sqlSession.insert(InsertUser,vo);
	}
	@Override
	public void updateUserRental(userVO vo) {
		sqlSession.update(UpdateUserRental,vo);
	}
	@Override
	public userVO selectUser(String userid) {
		return (userVO)sqlSession.selectOne(SelectUser,userid);
	}
	@Override
	public userVO selectID(String userid) {
		return (userVO)sqlSession.selectOne(SelectID,userid);
	}
	@Override
	public userVO selectIDstate(String userid) {
		return (userVO)sqlSession.selectOne(SelectIDstate,userid);
	}
	@Override
	public boolean existID(String userid) {
		return sqlSession.selectOne(ExistID,userid);
	}
	
}