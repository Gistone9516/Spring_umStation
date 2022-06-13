package com.spring.test.persistence;

import com.spring.test.domain.userVO;

public interface userDAO {
	
	public String getTime();
	
	public void insertUser(userVO vo);
	
	public void updateUserRental(userVO vo);
	
	public userVO selectUser(String userid);
	
	public userVO selectID(String userid);
	
	public userVO selectIDstate(String userid);
	
	public boolean existID(String userid);
}