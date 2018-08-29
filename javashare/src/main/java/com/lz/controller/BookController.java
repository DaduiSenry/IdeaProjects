package com.lz.controller;

import com.lz.po.Book;
import com.lz.service.BookService;
import org.codehaus.jackson.map.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class BookController extends BaseController<BookService> {
    @RequestMapping("/insertbook")
    public void insertBook(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Book book=new Book();
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int insertBook = service.insertBook(book);
        System.out.println(insertBook);
    }
    @RequestMapping("/deletebook")
    public void deleteIQ(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Book book=new Book();
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int deleteBook = service.deleteBook(book);
        System.out.println(deleteBook);
    }
    @RequestMapping("/updatebook")
    public void updateIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        int updateBook = service.updateBook(book);
        System.out.println(updateBook);
    }
    @RequestMapping("/selectbook")
    public void selectIQ(HttpServletRequest request, HttpServletResponse response) {
        String sid=request.getParameter("id");
        int id=0;
        if(sid!=null) {
            id=Integer.parseInt(sid);
        }
        String name=request.getParameter("name");
        String path=request.getParameter("path");
        String kind=request.getParameter("kind");
        Book book=new Book();
        book.setId(id);
        book.setName(name);
        book.setPath(path);
        book.setKind(kind);
        List<Book> selectBook = service.selectBook(book);
        System.out.println(selectBook);
    }
}
