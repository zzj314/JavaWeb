package com.guigu.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("文件上传");
//        System.out.println(req.getParameter("username"));//客户端已流的形式发送，所有直接收不到，为null
//        System.out.println(req.getParameter("photo"));
//        ServletInputStream inputStream = req.getInputStream();
//        byte[] buffer = new byte[1024000];
//        int read = inputStream.read(buffer);
//        System.out.println(new String(buffer,0,read));
        //1.先判断上传的数据是否是多段数据，因为文件上传才是多段数据
        if(ServletFileUpload.isMultipartContent(req)){
            //创建FileItemFactory工厂类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpLoad类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem :
                        list) {
                    if (fileItem.isFormField()){
                        System.out.println("表单name属性值:"+fileItem.getFieldName());
                        //解决乱码问题
                        System.out.println("表单value属性值:"+fileItem.getString("UTF-8"));
                    }else {
                        //上传的是文件
                        System.out.println("name:"+fileItem.getFieldName());
                        System.out.println("文件名:"+fileItem.getName());

                        fileItem.write(new File("E:\\"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
