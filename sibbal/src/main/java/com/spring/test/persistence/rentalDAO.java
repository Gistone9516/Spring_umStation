package com.spring.test.persistence;

import com.spring.test.domain.rental_logVO;
import com.spring.test.domain.rental_umVO;

public interface rentalDAO {
	
	public String getTime();
	public void insertUm(rental_umVO vo);
	public void insertUmlog(rental_logVO vo);
	public void updateUm(rental_umVO vo);
	public rental_umVO selectUm(String Um);
	public rental_umVO selectUmcode(String Umcode);
	public rental_logVO selectUmlog(String Umlog_num);

}