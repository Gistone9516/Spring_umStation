package com.spring.test.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.test.domain.rental_logVO;
import com.spring.test.domain.rental_umVO;

@Repository //DAO를 스프링에 인식시키기 위해서 사용
public class rentalDAOImpl implements rentalDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String GetTime = "RentalMapper.getTime";
	private static final String InsertUm = "RentalMapper.insertUm";
	private static final String InsertUmlog = "RentalMapper.insertUmlog";
	private static final String UpdateUm = "RentalMapper.updateUm";
	private static final String SelectUm = "RentalMapper.selectUm";
	private static final String SelectUmcode = "RentalMapper.selectUmcode";
	private static final String SelectUmlog = "RentalMapper.selectUmlog";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
		
	}
	@Override
	public void insertUm(rental_umVO vo) {
		sqlSession.insert(InsertUm,vo);
	}
	@Override
	public void insertUmlog(rental_logVO vo) {
		sqlSession.insert(InsertUmlog,vo);
	}
	@Override
	public void updateUm(rental_umVO vo) {
		sqlSession.update(UpdateUm,vo);
	}
	@Override
	public rental_umVO selectUm(String Um) {
		return (rental_umVO)sqlSession.selectOne(SelectUm,Um);
	}
	@Override
	public rental_umVO selectUmcode(String Umcode) {
		return (rental_umVO)sqlSession.selectOne(SelectUmcode, Umcode);
	}
	@Override
	public rental_logVO selectUmlog(String Umlog_num) {
		return (rental_logVO)sqlSession.selectOne(SelectUmlog, Umlog_num);
	}

	
}