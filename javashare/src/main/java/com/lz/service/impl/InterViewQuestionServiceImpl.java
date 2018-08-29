package com.lz.service.impl;

import com.lz.mapper.InterViewQuestionMapper;
import com.lz.po.InterViewQuestion;
import com.lz.service.InterViewQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InterViewQuestionServiceImpl implements InterViewQuestionService {
    @Autowired
    private InterViewQuestionMapper iqMapper;


    public void setIqMapper(InterViewQuestionMapper iqMapper) {
        this.iqMapper = iqMapper;
    }

    @Override
    public int insertIQ(InterViewQuestion iq) {
        int insertIQ = iqMapper.insertIQ(iq);
        return insertIQ;
    }

    @Override
    public int deleteIQ(int id) {
        int deleteIQ = iqMapper.deleteIQ(id);
        return deleteIQ;
    }

    @Override
    public int updateIQ(InterViewQuestion iq) {
        int updateIQ = iqMapper.updateIQ(iq);
        return updateIQ;
    }

    @Override
    public List<InterViewQuestionService> selectIQ(InterViewQuestion iq) {
        List<InterViewQuestionService> selectIQ = iqMapper.selectIQ(iq);
        return selectIQ;
    }
}
