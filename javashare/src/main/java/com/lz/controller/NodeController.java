package com.lz.controller;

import com.lz.po.Node;
import com.lz.service.NodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class NodeController extends BaseController<NodeService> {
    @RequestMapping("/insertnode")
    public void insertBook(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Node node=new Node();
        node.setName(name);
        node.setPath(path);
        node.setKind(kind);
        int insertNode = service.insertNode(node);
        System.out.println(insertNode);
    }
    @RequestMapping("/deletenode")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Node book=new Node();
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int deleteNode = service.deleteNode(book);
        System.out.println(deleteNode);
    }
    @RequestMapping("/updatenode")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Node book=new Node();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int updateNode = service.updateNode(book);
        System.out.println(updateNode);
    }
    @RequestMapping("/selectnode")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=0;
        if(sid!=null) {
            id=Integer.parseInt(sid);
        }
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Node book=new Node();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        List<Node> selectNode = service.selectNode(book);
        System.out.println(selectNode);
    }
}
