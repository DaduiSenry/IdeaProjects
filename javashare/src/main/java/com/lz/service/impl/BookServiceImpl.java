package com.lz.service.impl;

import com.lz.mapper.BookMapper;
import com.lz.po.Book;
import com.lz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insertBook(Book book) {
        int i = bookMapper.insertBook(book);
        return i;
    }

    @Override
    public int deleteBook(Book book) {
        int i = bookMapper.deleteBook(book);
        return i;
    }

    @Override
    public int updateBook(Book book) {
        int i = bookMapper.updateBook(book);
        return i;
    }

    @Override
    public List<Book> selectBook(Book book) {
        List<Book> books = bookMapper.selectBook(book);
        return books;
    }
}
