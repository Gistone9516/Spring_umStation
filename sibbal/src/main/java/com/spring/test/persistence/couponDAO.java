package com.spring.test.persistence;

import java.util.List;

import com.spring.test.domain.couponVO;
import com.spring.test.domain.rental_logVO;
import com.spring.test.domain.rental_umVO;

public interface couponDAO {
	
	public String getTime();
	public List<couponVO> selectCoupon(String id);

}