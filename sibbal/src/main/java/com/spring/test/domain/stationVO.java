package com.spring.test.domain;

public class stationVO {
	
	private String station_num;
	private float station_latitude;
	private float station_longitude;
	private int station_haveUm;
	private String manager_id;
	
	public String getstation_num() {
		return station_num;
	}
	public void setstation_num(String num) {
		this.station_num = num ;
	}
	
	public float getStation_latitude() {
		return station_latitude;
	}
	public void setStation_latitude(float latitude) {
		this.station_latitude =  latitude;
	}
	
	public float getStation_longitude() {
		return station_longitude;
	}
	public void setStation_longitude(float longitude) {
		this.station_longitude =  longitude;
	}
	
	public int getStation_haveUm() {
		return station_haveUm;
	}
	public void setStation_haveUm(int haveUm) {
		this.station_haveUm =  haveUm;
	}
	public String getStation_manager_id() {
		return manager_id;
	}
	public void setStation_manager_id(String manager_id) {
		this.manager_id =  manager_id;
	}
	
}
