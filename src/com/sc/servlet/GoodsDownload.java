package com.sc.servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @PackageName com.sc.servlet
 * @Classname GoodsDownload
 * @Description TODO
 * @Date 2021/6/15 21:00
 * @Created by ChenLong
 */
@WebServlet("/GoodsDownload")
public class GoodsDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");

        //1、创建组件对象
        SmartUpload smartUpload=new SmartUpload();
        //2、初始化
        smartUpload.initialize(getServletConfig(),req,resp);
        //3、设置显示保存对话框
        smartUpload.setContentDisposition(null);
        //4、下载文件
        try {
            smartUpload.downloadFile("upload/"+name);
        } catch (SmartUploadException e) {
            e.printStackTrace();
            System.out.println("下载文件失败");
        }

    }
}
