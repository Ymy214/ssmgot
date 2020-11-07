package com.ike.service;


import com.ike.dao.TestMapper;

public class TestServiceImpl implements TestService {

    TestMapper testMapper;
    public void setTestMapper(TestMapper testMapper) {
        this.testMapper = testMapper;
    }
}
