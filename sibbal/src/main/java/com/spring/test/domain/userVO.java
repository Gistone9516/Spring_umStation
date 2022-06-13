package com.spring.test.domain;

public class userVO {

	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_hp; //폰 번호
	private String user_birth;
	private String user_umCode;
	private String user_rental;
	private int user_ap; //누적 포인트
	private int user_lp; //잔여 포인트
	
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String id) {
		this.user_id = id ;
	}
	public String getuser_name() {
		return user_name;
	}
	public void setuser_name(String name) {
		this.user_name = name;
	}
	public String getuser_pw() {
		return user_pw;
	}
	public void setuser_pw(String pw) {
		this.user_pw = pw;
	}
	public String getuser_hp() {
		return user_hp;
	}
	public void setuser_hp(String hp) {
		this.user_hp = hp;
	}
	public String getuser_birth() {
		return user_birth;
	}
	public void setuser_birth(String birth) {
		this.user_birth = birth;
	}
	public String getuser_umCode() {
		return user_umCode;
	}
	public void setuser_umCode(String umCode) {
		this.user_umCode = umCode;
	}
	public String getuser_rental() {
		return user_rental;
	}
	public void setuser_rental(String rental) {
		this.user_rental = rental;
	}
	public int getuser_ap() {
		return user_ap;
	}
	public void setuser_ap(int ap) {
		this.user_ap = ap;
	}
	public int getuser_lp() {
		return user_lp;
	}
	public void setuser_lp(int lp) {
		this.user_lp = lp;
	}
}