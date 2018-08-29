package com.lz.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lz.service.InterViewQuestionService;
import com.lz.po.InterViewQuestion;
@Controller
public class InterViewQuestionController extends BaseController<InterViewQuestionService> {
    @RequestMapping("/insertiq")
    public void insertIQ(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        InterViewQuestion iq=new InterViewQuestion();
        iq.setName(name);
        iq.setPath(path);
        iq.setKind(kind);
        int insertIQ = service.insertIQ(iq);
        System.out.println(insertIQ);
    }
    @RequestMapping("/deleteiq")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        int deleteIQ = service.deleteIQ(id);
        System.out.println(deleteIQ);
    }
    @RequestMapping("/updateiq")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        InterViewQuestion iq=new InterViewQuestion();
        iq.setId(id);
        iq.setName(name);
        iq.setPath(path);
        iq.setKind(kind);
        int updateIQ = service.updateIQ(iq);
        System.out.println(updateIQ);
    }
    @RequestMapping("/selectiq")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=0;
        if(sid!=null) {
            id=Integer.parseInt(sid);
        }
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        InterViewQuestion iq=new InterViewQuestion();
        iq.setId(id);
        iq.setName(name);
        iq.setPath(path);
        iq.setKind(kind);
        List<InterViewQuestionService> selectIQ = service.selectIQ(iq);
        System.out.println(selectIQ);
    }
}
