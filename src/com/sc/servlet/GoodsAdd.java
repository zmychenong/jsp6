package com.sc.servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sc.bean.Goods;
import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @PackageName com.sc.servlet
 * @Classname GoodDel
 * @Description TODO
 * @Date 2021/6/10 20:43
 * @Created by ChenLong
 */
@WebServlet("/GoodsAdd")
public class GoodsAdd extends HttpServlet {

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



        String gname = request.getParameter("gname");

        String gprices = request.getParameter("gprice");
        float gprice = Float.parseFloat(gprices);

        String gstocks = request.getParameter("gstock");
        int gstock = Integer.parseInt(gstocks);

        GoodsDao goodsDao = new GoodsDao();
        Goods goods = new Goods(0, gname, gprice, name, 1, gstock);
        try {
            goodsDao.add(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //添加完后，再请求查询的servlet，查询商品列表
        resp.sendRedirect("GoodsSelect");//重定向到查询servlet
    }
}
