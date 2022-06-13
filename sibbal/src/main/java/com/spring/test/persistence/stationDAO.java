package com.spring.test.persistence;

import java.util.ArrayList;
import java.util.List;

import com.spring.test.domain.stationVO;

public interface stationDAO {
	
	public String getTime();
	
	public void updateHaveUm(stationVO vo);

	public stationVO selectStation(String station_num);
	
	public List<stationVO> selectStationAll(stationVO sVO);
}