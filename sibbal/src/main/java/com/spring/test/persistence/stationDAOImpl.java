package com.spring.test.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.test.domain.stationVO;

@Repository //DAO를 스프링에 인식시키기 위해서 사용
public class stationDAOImpl implements stationDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String GetTime = "StationMapper.getTime";
	private static final String UpdateHaveUm = "StationMapper.updateHaveUm";
	private static final String SelectStation = "StationMapper.selectStation";
	private static final String SelectStationAll = "StationMapper.selectStationAll";

	@Override
	public String getTime() {
		return sqlSession.selectOne(GetTime);
		
	}
	@Override
	public void updateHaveUm(stationVO vo) {
		sqlSession.update(UpdateHaveUm,vo);
	}
	@Override
	public stationVO selectStation(String station_num) {
		return (stationVO)sqlSession.selectOne(SelectStation, station_num);
	}
	
	@Override
	public List<stationVO> selectStationAll(stationVO sVO) {
		List<stationVO> returnList = new ArrayList<>();
		sqlSession.select(SelectStationAll, sVO, new TestInnerResultHandler(returnList));
		return returnList;
	}

	
}