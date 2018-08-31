package com.lz.controller;

import com.lz.po.Book;
import com.lz.po.Node;
import com.lz.service.NodeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class NodeController extends BaseController<NodeService> {
    @RequestMapping("/insertnode")
    public void insertBook(@RequestParam(value = "node_file", required = false) MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException {
        String str = req.getParameter("node_kind");
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
            String uploadPath= "node"+ File.separator+"upload";
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
                Node node=new Node();
                node.setName(name);
                node.setKind(kind);
                node.setPath(path);
                int flag = service.insertNode(node);
                System.out.println(flag);
                if(flag==1){
                    res.getWriter().write("1");
                }

            }
        }
    }
    @RequestMapping("/deletenode")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("node_id");
        int id = Integer.parseInt(sid);
        Node node=new Node();
        node.setId(id);
        int deleteNode = service.deleteNode(node);
        System.out.println(deleteNode);
        if(deleteNode==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/updatenode")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid=request.getParameter("node_id");
        String name=request.getParameter("node_name");
        String path=request.getParameter("node_path");
        String kind=request.getParameter("node_kind");
        Node node=new Node();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            node.setId(id);
        }else{
            node.setId(0);
        }

        if(name.trim().length()!=0){
            node.setName(name);
        }
        if(path.trim().length()!=0){
            node.setPath(path);
        }
        if(kind.trim().length()!=0){
            node.setKind(kind);
        }
        int updateNode = service.updateNode(node);
        System.out.println(updateNode);
        if(updateNode==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/selectnode")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("node_id");
        String name=request.getParameter("node_name");
        String path=request.getParameter("node_path");
        String kind=request.getParameter("node_kind");
        Node node=new Node();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            node.setId(id);
        }else{
            node.setId(0);
        }

        if(name.trim().length()!=0){
            node.setName(name);
        }
        if(path.trim().length()!=0){
            node.setPath(path);
        }
        if(kind.trim().length()!=0){
            node.setKind(kind);
        }
        List<Node> selectNode = service.selectNode(node);
        System.out.println(selectNode);
        UserController.getJson(request, response, selectNode);
    }
}
