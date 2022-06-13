package com.spring.test.domain;

import java.util.Date;

public class rental_logVO {
	
	private String rental_num;
	private String rental_umCode;
	private String user_id;
	private String rental_date;
	private String rental_state;


	public String getrental_num() {
		return rental_num;
	}
	public void setrental_num(String num) {
		this.rental_num = num;
	}
	public String getrental_umCode() {
		return rental_umCode;
	}
	public void setrental_umCode(String umCode) {
		this.rental_umCode = umCode;
	}
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String id) {
		this.user_id = id;
	}
	public String getrental_date() {
		return rental_date;
	}
	public void setrental_date(String date) {
		this.rental_date = date;
	}
	public String getrental_state() {
		return rental_state;
	}
	public void setrental_state(String state) {
		this.rental_state = state;
	}

}