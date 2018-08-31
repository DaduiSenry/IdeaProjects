package com.lz.controller;

import com.lz.po.Video;
import com.lz.po.Video;
import com.lz.service.VideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class VideoController extends BaseController<VideoService> {
    @RequestMapping("/insertvideo")
    public void insertBook(@RequestParam(value = "video_file", required = false) MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException {
        String str = req.getParameter("video_kind");
//        System.out.println(str);
        String fileRealName = file.getOriginalFilename();
        long time=System.currentTimeMillis();
        String fileName=String.valueOf(time);
        String fileType=file.getContentType();
        String fileTypeStart=fileType.split("/")[0];
        String[] fileRealName1=fileRealName.split("\\.");
//        System.out.println(fileRealName+","+fileRealName1.length);

        String fileTypeEnd=fileRealName1[fileRealName1.length-1];
//        System.out.println(fileTypeStart+","+fileTypeEnd);
        if(!file.isEmpty()){
//            String desPath=req.getSession().getServletContext().getRealPath("/");
            String desPath="D:"+ File.separator+"javashareweb";
            String uploadPath= "video"+ File.separator+"upload";
            String fpath=desPath+ File.separator+uploadPath+File.separator+fileTypeStart+File.separator;     //文件保存路径
            File pat=new File(fpath);
            if(!pat.exists()){
                pat.mkdirs();
            }
            fileName=fileName+"."+fileTypeEnd;
//            System.out.println(fpath+fileName);
            File targetFile1=new File(fpath,fileName);
            OutputStream out=null;
            InputStream in=null;
            int length;
            try{
                out=new BufferedOutputStream(new FileOutputStream(targetFile1));
                in=new BufferedInputStream(file.getInputStream());
                byte[] bytes = file.getBytes();
                while((length=in.read(bytes))!=-1){
                    out.write(bytes,0,length);
                    out.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                out.close();
                in.close();
                String name=fileRealName;
                String kind=str;
                String path=fpath+fileName;
                Video video=new Video();
                video.setName(name);
                video.setKind(kind);
                video.setPath(path);
                int flag = service.insertVideo(video);
                System.out.println(flag);
                if(flag==1){
                    res.getWriter().write("1");
                }

            }
        }
    }
    @RequestMapping("/deletevideo")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("video_id");
        int id = Integer.parseInt(sid);
        Video video=new Video();
        video.setId(id);
        int deleteVideo = service.deleteVideo(video);
        System.out.println(deleteVideo);
        if(deleteVideo==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/updatevideo")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid=request.getParameter("video_id");
        String name=request.getParameter("video_name");
        String path=request.getParameter("video_path");
        String kind=request.getParameter("video_kind");
        Video video=new Video();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            video.setId(id);
        }else{
            video.setId(0);
        }

        if(name.trim().length()!=0){
            video.setName(name);
        }
        if(path.trim().length()!=0){
            video.setPath(path);
        }
        if(kind.trim().length()!=0){
            video.setKind(kind);
        }
        int updateVideo = service.updateVideo(video);
        System.out.println(updateVideo);
        if(updateVideo==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/selectvideo")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("video_id");
        String name=request.getParameter("video_name");
        String path=request.getParameter("video_path");
        String kind=request.getParameter("video_kind");
        Video video=new Video();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            video.setId(id);
        }else{
            video.setId(0);
        }

        if(name.trim().length()!=0){
            video.setName(name);
        }
        if(path.trim().length()!=0){
            video.setPath(path);
        }
        if(kind.trim().length()!=0){
            video.setKind(kind);
        }
        List<Video> selectVideo = service.selectVideo(video);
        System.out.println(selectVideo);
        UserController.getJson(request, response, selectVideo);
    }
}

