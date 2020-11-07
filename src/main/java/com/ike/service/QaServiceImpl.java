package com.ike.service;

import com.ike.dao.QaMapper;

public class QaServiceImpl implements QaService {

    private QaMapper qaMapper;
    public void setQaMapper(QaMapper qaMapper) {
        this.qaMapper = qaMapper;
    }
}
