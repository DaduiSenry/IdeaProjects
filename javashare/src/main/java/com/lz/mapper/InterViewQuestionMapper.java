package com.lz.mapper;

import java.util.List;

import com.lz.service.InterViewQuestionService;
import com.lz.po.InterViewQuestion;
import com.lz.service.InterViewQuestionService;

public interface InterViewQuestionMapper {
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
}
