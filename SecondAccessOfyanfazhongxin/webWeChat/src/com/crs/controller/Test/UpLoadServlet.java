package com.crs.controller.Test;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author RS
 * @Description: 文件上传服务器
 * @create 2021-04-29 15:38
 */
public class UpLoadServlet extends HttpServlet {
    /**
     * 处理文件上传请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先判断上传的数据是否为多段(只有多段的数据才是文件上传的)
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建FileItemFactory工厂接口实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于上传数据解析的ServletFileUpload工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //解析上传的数据，得到每一个表单项FileItem
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断，每一个表单项是普通的类型还是循环的表单项
                for (FileItem fileItem : list){
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        //UTF-8：防止中文乱码
                        System.out.println("表单项的value属性值：" + fileItem.getString("UTF-8"));
                    }else{
                        //上传的文件
                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        //将文件写进硬盘
                        fileItem.write(new File("d:/JavaIDEAcode/uploadtohere/" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

