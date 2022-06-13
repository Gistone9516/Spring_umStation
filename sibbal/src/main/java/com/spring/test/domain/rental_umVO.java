package com.spring.test.domain;

import java.util.Date;

public class rental_umVO {
	
	private String rental_umCode;
	private String rental_date;
	private String rental_statCode;
	private String user_id;


	
	public String getrental_umCode() {
		return rental_umCode;
	}
	public void setrental_umCode(String umCode) {
		this.rental_umCode = umCode;
	}
	public String getrental_date() {
		return rental_date;
	}
	public void setrental_date(String date) {
		this.rental_date = date;
	}

	public String getrental_statCode() {
		return rental_statCode;
	}
	public void setrental_statCode(String statCode) {
		this.rental_statCode = statCode;
	}

	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String id) {
		this.user_id = id;
	}


}