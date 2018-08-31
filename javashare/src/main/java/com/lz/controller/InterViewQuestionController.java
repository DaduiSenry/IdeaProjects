package com.lz.controller;

import java.io.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.annotation.XmlElementDecl;

import jdk.nashorn.internal.objects.Global;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lz.service.InterViewQuestionService;
import com.lz.po.InterViewQuestion;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InterViewQuestionController extends BaseController<InterViewQuestionService> {
    @RequestMapping("/insertiq")
    @ResponseBody
    public void insertIQ(@RequestParam(value = "iq_file", required = false) MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws FileUploadException, IOException {
        String str = req.getParameter("iq_kind");
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
            String uploadPath= "InsertViewQusetion"+ File.separator+"upload";
            String fpath=desPath+File.separator+uploadPath+File.separator+fileTypeStart+File.separator;     //文件保存路径
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
                InterViewQuestion iq=new InterViewQuestion();
                iq.setName(name);
                iq.setKind(kind);
                iq.setPath(path);
                int flag = service.insertIQ(iq);
                System.out.println(flag);
                if(flag==1){
                    res.getWriter().write("1");
                }

            }
        }


//        String name=request.getParameter("name");
//        String path=request.getParameter("path");
//        String kind=request.getParameter("kind");
//        InterViewQuestion iq=new InterViewQuestion();
//        iq.setName(name);
//        iq.setPath(path);
//        iq.setKind(kind);
//        int insertIQ = service.insertIQ(iq);
//        System.out.println(insertIQ);
    }

    @RequestMapping("/deleteiq")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("iq_id");
        int id = Integer.parseInt(sid);
        int deleteIQ = service.deleteIQ(id);
        System.out.println(deleteIQ);
        if(deleteIQ==1){
            response.getWriter().write("1");
        }
    }

    @RequestMapping("/updateiq")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("iq_id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("iq_name");
        String path = request.getParameter("iq_path");
        String kind = request.getParameter("iq_kind");
        InterViewQuestion iq = new InterViewQuestion();
        if(sid.trim().length()!=0){
            iq.setId(id);
        }

        if(name.trim().length()!=0){
            iq.setName(name);
        }
        if(path.trim().length()!=0){
            iq.setPath(path);
        }
        if(kind.trim().length()!=0){
            iq.setKind(kind);
        }
        int updateIQ = service.updateIQ(iq);
        System.out.println(iq);
        System.out.println(updateIQ);
        if(updateIQ==1){
            response.getWriter().write("1");
        }
    }

    @RequestMapping("/selectiq")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid = request.getParameter("iq_id");
        String name = request.getParameter("iq_name");
        String path = request.getParameter("iq_path");
        String kind = request.getParameter("iq_kind");
        InterViewQuestion iq = new InterViewQuestion();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            iq.setId(id);
        }else{
            iq.setId(0);
        }

        if(name.trim().length()!=0){
            iq.setName(name);
        }
        if(path.trim().length()!=0){
            iq.setPath(path);
        }
        if(kind.trim().length()!=0){
            iq.setKind(kind);
        }
        List<InterViewQuestionService> selectIQ = service.selectIQ(iq);
        System.out.println(selectIQ);
        UserController.getJson(request, response, selectIQ);
    }

    @RequestMapping("/setiqs")
    public void setIQs(HttpServletRequest request, HttpServletResponse response) {
        List<InterViewQuestionService> iqs = service.selectAllIQ();
        request.setAttribute("iqs",iqs);
    }

}
