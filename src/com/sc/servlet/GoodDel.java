package com.sc.servlet;

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
@WebServlet("/GoodDel")
public class GoodDel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gids = req.getParameter("gid");
        int gid = Integer.parseInt(gids);
        System.out.println("当前删除商品的编号:" + gid);

        GoodsDao goodsDao = new GoodsDao();
        try {
            goodsDao.delete(gid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //删完后，再请求查询的servlet，查询商品列表
        resp.sendRedirect("GoodsSelect");//重定向到查询servlet
    }
}
