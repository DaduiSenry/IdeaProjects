package com.lz.controller;

import com.lz.po.Video;
import com.lz.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class VideoController extends BaseController<VideoService> {
    @RequestMapping("/insertvideo")
    public void insertBook(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Video video=new Video();
        video.setName(name);
        video.setPath(path);
        video.setKind(kind);
        int insertVideo = service.insertVideo(video);
        System.out.println(insertVideo);
    }
    @RequestMapping("/deletevideo")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Video video=new Video();
        video.setName(name);
        video.setPath(path);
        video.setKind(kind);
        int deleteVideo = service.deleteVideo(video);
        System.out.println(deleteVideo);
    }
    @RequestMapping("/updatevideo")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Video book=new Video();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int updateVideo = service.updateVideo(book);
        System.out.println(updateVideo);
    }
    @RequestMapping("/selectvideo")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=0;
        if(sid!=null) {
            id=Integer.parseInt(sid);
        }
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Video book=new Video();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        List<Video> selectVideo = service.selectVideo(book);
        System.out.println(selectVideo);
    }
}
