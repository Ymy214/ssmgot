package com.ike.service;


import com.ike.dao.ExampleMapper;
import com.ike.pojo.Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public class ExampleServiceImpl implements ExampleService {

    private ExampleMapper exampleMapper;
    public void setExampleMapper(ExampleMapper exampleMapper) {
        this.exampleMapper = exampleMapper;
    }

    public List<Example> getAllExamples() {
        return exampleMapper.getAllExamples();
    }

    public List<Example> getAllExamples(int page, int limit) {
        return exampleMapper.getAllExamples1((page-1)*limit, limit);
    }

    public int count() {
        return exampleMapper.count();
    }
}
