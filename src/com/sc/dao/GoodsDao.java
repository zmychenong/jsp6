package com.sc.dao;

import com.sc.bean.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName com.sc.dao
 * @Classname GoodsDao
 * @Description TODO
 * @Date 2021/6/8 20:20
 * @Created by ChenLong
 */
public class GoodsDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    //通过id获取对象
    public Goods get(int gid) throws ClassNotFoundException, SQLException {
        Goods goods = null;
        //获取连接
        connection = DBConn.getConn();
        //3、通过连接对象，创建陈述对象
        String sql = "select * from goods where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, gid);
        //4、通过陈述对象执行sql语句，获取结果集
        resultSet = preparedStatement.executeQuery();
        //5、处理结果集
        while (resultSet.next()) {
            goods = new Goods();
            //取出列的值赋给对应的属性
            goods.setGid(resultSet.getInt("gid"));
            goods.setGname(resultSet.getString("gname"));
            goods.setGimg(resultSet.getString("gimg"));
            goods.setGprice(resultSet.getFloat("gprice"));
            goods.setGstock(resultSet.getInt("gstock"));
            goods.setGnum(resultSet.getInt("gnum"));
        }

        System.out.println("执行数据库成功！");
        //6、关闭数据库资源
        DBConn.close(resultSet, preparedStatement, connection);
        return goods;
    }

    public void add(Goods goods) throws SQLException {
        connection = DBConn.getConn();
        String sql = "insert into goods values(null,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, goods.getGname());
        preparedStatement.setFloat(2, goods.getGprice());
        preparedStatement.setString(3, goods.getGimg());
        preparedStatement.setInt(4, goods.getGnum());
        preparedStatement.setInt(5, goods.getGstock());
        preparedStatement.executeUpdate();
        DBConn.close(resultSet, preparedStatement, connection);
    }

    public void update(Goods goods) throws SQLException {
        connection = DBConn.getConn();
        String sql = "update goods set gname=?,gprice=?,gimg=?,gnum=?,gstock=? where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, goods.getGname());
        preparedStatement.setFloat(2, goods.getGprice());
        preparedStatement.setString(3, goods.getGimg());
        preparedStatement.setInt(4, goods.getGnum());
        preparedStatement.setInt(5, goods.getGstock());
        preparedStatement.setInt(6, goods.getGid());
        preparedStatement.executeUpdate();
        DBConn.close(resultSet, preparedStatement, connection);
    }

    public void delete(int gid) throws SQLException {
        connection = DBConn.getConn();
        String sql = "delete from goods where gid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, gid);
        preparedStatement.executeUpdate();
        DBConn.close(resultSet, preparedStatement, connection);
    }

    public List<Goods> select() throws SQLException {
        List<Goods> list = new ArrayList<>();
        connection = DBConn.getConn();
        String sql = "select * from goods";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Goods goods = new Goods();
            goods.setGid(resultSet.getInt("gid"));
            goods.setGname(resultSet.getString("gname"));
            goods.setGprice(resultSet.getFloat("gprice"));
            goods.setGimg(resultSet.getString("gimg"));
            goods.setGnum(resultSet.getInt("gnum"));
            goods.setGstock(resultSet.getInt("gstock"));
            list.add(goods);
        }
        DBConn.close(resultSet, preparedStatement, connection);
        return list;
    }

}
