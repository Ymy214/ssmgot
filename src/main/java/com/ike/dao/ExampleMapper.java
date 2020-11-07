package com.ike.dao;

import com.ike.pojo.Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExampleMapper {
    List<Example> getAllExamples();

    List<Example> getAllExamples1(@Param("start") int s, @Param("limit") int l);

    int count();
}
