package com.lz.service.impl;

import com.lz.mapper.VideoMapper;
import com.lz.po.Video;
import com.lz.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    public void setVideoMapper(VideoMapper videoMapper) {
        this.videoMapper = videoMapper;
    }

    @Override
    public int insertVideo(Video video) {
        int i = videoMapper.insertVideo(video);
        return i;
    }

    @Override
    public int deleteVideo(Video video) {
        int i = videoMapper.deleteVideo(video);
        return i;
    }

    @Override
    public int updateVideo(Video video) {
        int i = videoMapper.updateVideo(video);
        return i;
    }

    @Override
    public List<Video> selectVideo(Video video) {
        List<Video> videos = videoMapper.selectVideo(video);
        return videos;
    }
}
