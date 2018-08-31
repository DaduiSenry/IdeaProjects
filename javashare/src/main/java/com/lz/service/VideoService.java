package com.lz.service;

import com.lz.po.Video;

import java.util.List;

public interface VideoService {
    /**
     * 添加视频
     * @param video
     * @return
     */
    int insertVideo(Video video);
    /**
     * 删除视频
     * @param video
     * @return
     */
    int deleteVideo(Video video);
    /**
     * 修改视频
     * @param video
     * @return
     */
    int updateVideo(Video video);
    /**
     * 查询视频
     * @param video
     * @return
     */
    List<Video> selectVideo(Video video);
    /**
     * 查询全部视频
     * @return
     */
    List<Video> selectAllVideo();
}
