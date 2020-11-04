package com.atg.service.impl;

import com.atg.dao.BookDao;
import com.atg.dao.impl.BookDaoImpl;
import com.atg.pojo.Book;
import com.atg.pojo.Page;
import com.atg.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    //依赖DAO，去访问数据库
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录条数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录条数
        page.setPageTotalCount(pageTotalCount);
        //总页码页数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置总页码页数
        page.setPageTotal(pageTotal);
        //数据校验 ,但不优雅，每个模块有分页都要做
      /*  if (pageNo<1){
            pageNo = 1;
        }
        if (pageNo>pageTotal){
            pageNo = pageTotal;
        }*/
        //设置当前页码数
        page.setPageNo(pageNo);
        //当前页的开始索引
        int begin = (page.getPageNo()-1)*pageSize;
        //当前页的数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页的数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录条数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录条数
        page.setPageTotalCount(pageTotalCount);
        //总页码页数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize >0) {
            pageTotal+=1;
        }
        //设置总页码页数
        page.setPageTotal(pageTotal);
        //设置当前页码数
        page.setPageNo(pageNo);
        //当前页的开始索引
        int begin = (page.getPageNo()-1)*pageSize;
        //当前页的数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页的数据
        page.setItems(items);
        return page;
    }
}
