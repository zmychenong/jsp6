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
import java.util.List;

/**
 * @PackageName com.sc.servlet
 * @Classname GoodsSelect
 * @Description TODO
 * @Date 2021/6/10 20:10
 * @Created by ChenLong
 */
@WebServlet("/GoodsSelect")
public class GoodsSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> list = null;
        try {
            list = goodsDao.select();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("goodslist", list);
        req.getRequestDispatcher("goodsselect.jsp").forward(req, resp);//转发
    }
}
