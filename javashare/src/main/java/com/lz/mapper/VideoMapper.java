package com.lz.mapper;

import com.lz.po.Node;
import com.lz.po.Video;

import java.util.List;

public interface VideoMapper {
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
}
