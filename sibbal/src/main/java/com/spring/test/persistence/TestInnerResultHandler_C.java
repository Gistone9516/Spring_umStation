package com.spring.test.persistence;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.spring.test.domain.couponVO;
import com.spring.test.domain.stationVO;

public class TestInnerResultHandler_C implements ResultHandler {

    public List<couponVO> returnCList = null;

    public TestInnerResultHandler_C() {

    }
    public TestInnerResultHandler_C(List<couponVO> returnList) {
        this.returnCList = returnList;
    }

    @Override
    public void handleResult(ResultContext context) {
        Object object = context.getResultObject();
        returnCList.add((couponVO) object);
    }
}