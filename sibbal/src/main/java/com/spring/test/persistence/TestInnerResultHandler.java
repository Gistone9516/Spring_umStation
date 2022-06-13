package com.spring.test.persistence;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.spring.test.domain.couponVO;
import com.spring.test.domain.stationVO;

public class TestInnerResultHandler implements ResultHandler {

    public List<stationVO> returnList = null;
    public List<couponVO> returnCList = null;

    public TestInnerResultHandler() {

    }
    public TestInnerResultHandler(List<stationVO> returnList) {
        this.returnList = returnList;
    }

    @Override
    public void handleResult(ResultContext context) {
        Object object = context.getResultObject();
        returnList.add((stationVO) object);
    }
}