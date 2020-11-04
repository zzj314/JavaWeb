package com.atg.web;

import com.atg.pojo.Book;
import com.atg.pojo.Page;
import com.atg.service.BookService;
import com.atg.service.impl.BookServiceImpl;
import com.atg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
    /**
     * 处理分页
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{

        //1.获取请求参数pageNo,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用服务获取page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //设置URL
        page.setUrl("manager/bookServlet?action=page");
        //3.保存page对象到Request域中
        req.setAttribute("page", page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        pageNo+=1;
        //1.获取请求的参数，封装成book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用bookservice.addBook()保存图书
        bookService.addBook(book);
        //3.跳到图书列表页面
//        req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        //不应该用请求转发，因为是一次请求，会记录最后一次请求的内容,地址不变
       // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        //响应重定向的/表示端口号，地址改变
        //resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
        //resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*    写到工具类
        String id = req.getParameter("id");
        int i = 0;
        try {
            i = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookService.deleteBookById()
        bookService.deleteBookById(id);
        //
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }
    //修改操作需要id
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.updateBook(book)
        bookService.updateBook(book);
        //3.重定向到管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1.
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2.
        Book book = bookService.queryBookById(id);
        //3.
        req.setAttribute("book", book);
        //4.
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
}
