package com.sc.servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;
import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @PackageName com.sc.servlet
 * @Classname GoodsUpdate
 * @Description TODO
 * @Date 2021/6/15 18:48
 * @Created by ChenLong
 */
@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、创建组件对象
        SmartUpload smartUpload=new SmartUpload();
        //2、初始化
        smartUpload.initialize(getServletConfig(),req,resp);
        //3、限制类型
        smartUpload.setAllowedFilesList("jpg,jpeg,png,gif,JPG,JPEG,PNG,GIF");

        String name =null;
        Request request = smartUpload.getRequest();
        try {
            //4、上传文件
            smartUpload.upload();
            //5、获取文件对象
            File file = smartUpload.getFiles().getFile(0);
            //6、判断文件对象
            if(file.isMissing()){//用户未选择文件
                name=request.getParameter("gimg");
            }else{//用户选择了文件
                String path = req.getServletContext().getRealPath("upload");
                System.out.println("保存的路径："+path);
                //另存到upload目录
                name=file.getFileName();
                file.saveAs(path+"/"+name);
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        }



        //获取所有参数值
        req.setCharacterEncoding("utf-8");
        String gids = request.getParameter("gid");
        int gid = Integer.parseInt(gids);
        String gnums=request.getParameter("gnum");
        int gnum=Integer.parseInt(gnums);
        String gimg=name;
        String gname=request.getParameter("gname");
        String gprices=request.getParameter("gprice");
        float gprice=Float.parseFloat(gprices);
        String gstocks=request.getParameter("gstock");
        int gstock=Integer.parseInt(gstocks);

        Goods goods=new Goods(gid,gname,gprice,gimg,gnum,gstock);

        GoodsDao goodsDao=new GoodsDao();
        try {
            goodsDao.update(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //修改完后，再请求查询的servlet，查询商品列表
        resp.sendRedirect("GoodsSelect");//重定向到查询servlet
    }
}
