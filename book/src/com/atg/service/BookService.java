package com.atg.service;

import com.atg.pojo.Book;
import com.atg.pojo.Page;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void deleteBookById(Integer id);

    void updateBook(Book book);

    Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);


}
