package com.lz.mapper;

import com.lz.po.Node;

import java.util.List;

public interface NodeMapper {
    /**
     * 添加笔记
     * @param node
     * @return
     */
    int insertNode(Node node);
    /**
     * 删除笔记
     * @param node
     * @return
     */
    int deleteNode(Node node);
    /**
     * 修改笔记
     * @param node
     * @return
     */
    int updateNode(Node node);
    /**
     * 查询笔记
     * @param node
     * @return
     */
    List<Node> selectNode(Node node);

    /**
     * 查询全部笔记
     * @return
     */
    List<Node> selectAllNode();
}
