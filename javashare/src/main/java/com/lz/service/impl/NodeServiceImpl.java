package com.lz.service.impl;

import com.lz.mapper.NodeMapper;
import com.lz.po.Node;
import com.lz.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeMapper nodeMapper;

    public void setNodeMapper(NodeMapper nodeMapper) {
        this.nodeMapper = nodeMapper;
    }

    @Override
    public int insertNode(Node node) {
        int i = nodeMapper.insertNode(node);
        return i;
    }

    @Override
    public int deleteNode(Node node) {
        int i = nodeMapper.deleteNode(node);
        return i;
    }

    @Override
    public int updateNode(Node node) {
        int i = nodeMapper.updateNode(node);
        return i;
    }

    @Override
    public List<Node> selectNode(Node node) {
        List<Node> nodes = nodeMapper.selectNode(node);
        return nodes;
    }

    @Override
    public List<Node> selectAllNode() {
        List<Node> nodes = nodeMapper.selectAllNode();
        return nodes;
    }
}
