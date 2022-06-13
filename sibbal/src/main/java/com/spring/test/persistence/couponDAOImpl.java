package com.spring.test.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.test.domain.couponVO;

@Repository //DAO를 스프링에 인식시키기 위해서 사용
public class couponDAOImpl implements couponDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String GetTime = "CouponMapper.getTime";
	private static final String SelectCoupon = "CouponMapper.selectCoupon";

	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
		
	}
	@Override
	public List<couponVO> selectCoupon(String userid) {
		List<couponVO> returnList = new ArrayList<>();
		returnList = sqlSession.selectList(SelectCoupon, userid);
		return returnList;
	}

}