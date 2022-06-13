package com.spring.test.domain;

import java.util.Date;

public class couponVO {

	private String coupon_num;
	private int coupon_price;
	private String coupon_date;
	private String user_id;
	
	public String getcoupon_num() {
		return coupon_num;
	}
	public void setcoupon_num(String num) {
		this.coupon_num = num ;
	}
	
	public int getcoupon_price() {
		return coupon_price;
	}
	public void setcoupon_price(int price) {
		this.coupon_price =  price;
	}
	
	public String getcoupon_date() {
		return coupon_date;
	}
	public void setcoupon_date(String date) {
		this.coupon_date =  date;
	}
	public String getuser_id() {
		return user_id;
	}
	public void setuser_id(String id) {
		this.user_id =  id;
	}
	
}
