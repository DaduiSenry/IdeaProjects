package com.lz.mapper;

import java.util.List;

import com.lz.po.Book;

public interface BookMapper {
    /**
     * 添加书籍
     * @param book
     * @return
     */
    int insertBook(Book book);
    /**
     * 删除书籍
     * @param book
     * @return
     */
    int deleteBook(Book book);
    /**
     * 修改书籍
     * @param book
     * @return
     */
    int updateBook(Book book);
    /**
     * 查询书籍
     * @param book
     * @return
     */
    List<Book> selectBook(Book book);
}
