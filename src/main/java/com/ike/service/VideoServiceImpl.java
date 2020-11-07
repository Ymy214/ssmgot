package com.ike.service;

import com.ike.dao.StudentMapper;
import com.ike.dao.VideoMapper;

public class VideoServiceImpl implements VideoService {

    private VideoMapper videoMapper;
    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

}
