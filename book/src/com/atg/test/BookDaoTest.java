package com.atg.test;

import com.atg.dao.BookDao;
import com.atg.dao.impl.BookDaoImpl;
import com.atg.pojo.Book;
import com.atg.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "帅", "19", new BigDecimal(99), 888, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"大家","哥",new BigDecimal(9999),11000,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook :
                bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }
    @Test
    public void queryForpageItems(){
        for (Book book :
                bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForpageItemsByPrice(){
        for (Book book :
                bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(book);
        }
    }
}