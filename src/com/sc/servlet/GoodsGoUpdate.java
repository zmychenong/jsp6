package com.sc.servlet;

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
 * @Classname GoodsGoUpdate
 * @Description TODO
 * @Date 2021/6/15 18:31
 * @Created by ChenLong
 */
@WebServlet("/GoodsGoUpdate")
public class GoodsGoUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gids = req.getParameter("gid");
        int gid = Integer.parseInt(gids);
        System.out.println("当前修改商品的编号:" + gid);

        //通过gid查询商品其他信息
        GoodsDao goodsDao = new GoodsDao();
        Goods goods = null;
        try {
            goods = goodsDao.get(gid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        req.setAttribute("goods",goods);//设置属性
        req.getRequestDispatcher("goodsupdate.jsp").forward(req,resp);//转发
    }
}
