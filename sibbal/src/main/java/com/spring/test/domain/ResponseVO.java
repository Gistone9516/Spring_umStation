package com.spring.test.domain;

public class ResponseVO {
	
	public String response_type;

	
	public void setall(String type){
		this.response_type = type;
	}
	
	public String gettype() {
		return response_type;
	}
	public void settype(String type) {
		this.response_type = type ;
	}

}