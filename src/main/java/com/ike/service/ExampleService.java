package com.ike.service;

import com.ike.pojo.Example;

import java.util.List;

public interface ExampleService {
    List<Example> getAllExamples();

    List<Example> getAllExamples(int page, int limit);
    int count();
}
