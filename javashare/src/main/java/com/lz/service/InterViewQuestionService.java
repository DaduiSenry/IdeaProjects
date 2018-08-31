package com.lz.service;

import com.lz.po.InterViewQuestion;

import java.util.List;

public interface InterViewQuestionService {
    /**
     * 添加面试题
     * @param iq
     * @return
     */
    int insertIQ(InterViewQuestion iq);
    /**
     * 删除面试题
     * @param id
     * @return
     */
    int deleteIQ(int id);
    /**
     * 修改面试题
     * @param iq
     * @return
     */
    int updateIQ(InterViewQuestion iq);
    /**
     * 查找面试题
     * @param iq
     * @return
     */
    List<InterViewQuestionService> selectIQ(InterViewQuestion iq);
    /**
     * 查询全部面试题
     * @return
     */
    List<InterViewQuestionService> selectAllIQ();
}
