package com.guigu.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;


public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取下载的文件名
        String downloadFileName = "2.jpg";
        //System.out.println(downloadFileName);
        //2.获取下载的文件内容
        ServletContext servletContext = getServletContext();
        //3.获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/"+downloadFileName);
        System.out.println("下载的文件类型："+mimeType);
        //4.回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5.告诉客户端收到的数据是用在下载还是使用响应头
//        resp.setHeader("Content-Disposition", "attachment; filename="+downloadFileName);
//        resp.setHeader("Content-Disposition", "attachment; filename=22.jpg");//filename随便给
        //把文字转换成%xx%xx
//        resp.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode("中国.jpg", "UTF-8"));
       //resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) +"?=");

       // System.out.println(downloadFileName);
        //将内容传给客户端
        //InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        if (req.getHeader("User-Agent").contains("Firefox")){
            resp.setHeader("Content-Disposition", "attachment; filename==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes("UTF-8")) +"?=");
        }else {
            resp.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode("中国.jpg", "UTF-8"));
        }
        InputStream resourceAsStream = servletContext.getResourceAsStream( "/file/"+downloadFileName);
       // System.out.println(resourceAsStream);
        //获取响应的输出流
        OutputStream outputStream =resp.getOutputStream();
        //读取输入流中的数据，复制给输出流
        IOUtils.copy(resourceAsStream, outputStream);

    }
}
