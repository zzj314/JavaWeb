package com.atg.test;

import com.atg.pojo.Book;
import com.atg.pojo.Page;
import com.atg.service.BookService;
import com.atg.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "国", "1125", new BigDecimal(999), 99999, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "大家", "1125", new BigDecimal(888), 88888, 0, null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook :
                bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}