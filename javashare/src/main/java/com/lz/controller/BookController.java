package com.lz.controller;

import com.lz.po.Book;
import com.lz.po.InterViewQuestion;
import com.lz.service.BookService;
import org.codehaus.jackson.map.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
public class BookController extends BaseController<BookService> {
    @RequestMapping("/insertbook")
    public void insertBook(@RequestParam(value = "book_file", required = false) MultipartFile file, HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        String str = req.getParameter("book_kind");
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
            String uploadPath= "book"+ File.separator+"upload";
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
                Book book=new Book();
                book.setName(name);
                book.setKind(kind);
                book.setPath(path);
                int flag = service.insertBook(book);
                System.out.println(flag);
                if(flag==1){
                    res.getWriter().write("1");
                }

            }
        }
    }
    @RequestMapping("/deletebook")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid = request.getParameter("book_id");
        int id = Integer.parseInt(sid);
        Book book=new Book();
        book.setId(id);
        int deleteBook = service.deleteBook(book);
        System.out.println(deleteBook);
        if(deleteBook==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/updatebook")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sid=request.getParameter("book_id");
        String name=request.getParameter("book_name");
        String path=request.getParameter("book_path");
        String kind=request.getParameter("book_kind");
        Book book=new Book();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            book.setId(id);
        }else{
            book.setId(0);
        }

        if(name.trim().length()!=0){
            book.setName(name);
        }
        if(path.trim().length()!=0){
            book.setPath(path);
        }
        if(kind.trim().length()!=0){
            book.setKind(kind);
        }
        int updateBook = service.updateBook(book);
        System.out.println(updateBook);
        if(updateBook==1){
            response.getWriter().write("1");
        }
    }
    @RequestMapping("/selectbook")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("book_id");
        String name=request.getParameter("book_name");
        String path=request.getParameter("book_path");
        String kind=request.getParameter("book_kind");
        Book book=new Book();
        if(sid.trim().length()!=0){
            int id = Integer.parseInt(sid);
            book.setId(id);
        }else{
            book.setId(0);
        }

        if(name.trim().length()!=0){
            book.setName(name);
        }
        if(path.trim().length()!=0){
            book.setPath(path);
        }
        if(kind.trim().length()!=0){
            book.setKind(kind);
        }
        List<Book> selectBook = service.selectBook(book);
        System.out.println(selectBook);
        UserController.getJson(request, response, selectBook);
    }
}
