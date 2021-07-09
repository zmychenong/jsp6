package com.sc.servlet;

import com.sc.bean.Cars;
import com.sc.bean.Goods;
import com.sc.bean.Userinfo;
import com.sc.dao.CarsDao;
import com.sc.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @PackageName com.sc.servlet
 * @Classname CarsAdd
 * @Description TODO
 * @Date 2021/6/8 20:09
 * @Created by ChenLong
 */
@WebServlet("/CarsAdd")
public class CarsAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gids = req.getParameter("gid");
        int gid = Integer.parseInt(gids);
        System.out.println("当前加入商品的编号:" + gid);

        //获取当前用户id
        HttpSession session = req.getSession();
        Userinfo u = (Userinfo) session.getAttribute("nowuser");
        int uid = u.getId();

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

        //把用户id和商品信息封装成cars对象
        Cars cars = new Cars(0, goods.getGid(),
                goods.getGname(), goods.getGprice(), goods.getGimg(),
                goods.getGnum(), uid);

        //把cars对象添加到cars表
        CarsDao carsDao = new CarsDao();
        try {
            carsDao.add(cars);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //通过uid查询该用户购物车表中的所有商品
        List<Cars> list = null;
        try {
            list = carsDao.select(uid);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //把集合存入session
        session.setAttribute("carslist", list);
        //重定向到购物车页面
        resp.sendRedirect("cars.jsp");
    }
}
