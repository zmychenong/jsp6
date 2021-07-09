package com.sc.dao;

import com.sc.bean.Cars;
import com.sc.bean.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName com.sc.dao
 * @Classname CarsDao
 * @Description TODO
 * @Date 2021/6/8 20:48
 * @Created by ChenLong
 */
public class CarsDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void add(Cars cars) throws ClassNotFoundException, SQLException {
        //获取连接
        connection = DBConn.getConn();
        //3、通过连接对象，创建预编译陈述对象
        String sql = "insert into cars values(null,?,?,?,?,?,?)";//使用问号占位
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, cars.getGid());
        preparedStatement.setString(2, cars.getGname());
        preparedStatement.setFloat(3, cars.getGprice());
        preparedStatement.setString(4, cars.getGimg());
        preparedStatement.setInt(5, cars.getGnum());
        preparedStatement.setInt(6, cars.getUid());
        preparedStatement.executeUpdate();
        System.out.println("执行数据库成功！");
        //4、关闭数据库资源
        DBConn.close(resultSet, preparedStatement, connection);
    }


    //通过uid获取cars集合
    public List<Cars> select(int uid) throws ClassNotFoundException, SQLException {
        List<Cars> list = new ArrayList<>();
        //获取连接
        connection = DBConn.getConn();
        //3、通过连接对象，创建陈述对象
        String sql = "select * from cars where uid=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, uid);
        //4、通过陈述对象执行sql语句，获取结果集
        resultSet = preparedStatement.executeQuery();
        //5、处理结果集
        while (resultSet.next()) {
            Cars cars = new Cars();
            //取出列的值赋给对应的属性'
            cars.setCid(resultSet.getInt("cid"));
            cars.setGid(resultSet.getInt("gid"));
            cars.setGname(resultSet.getString("gname"));
            cars.setGimg(resultSet.getString("gimg"));
            cars.setGprice(resultSet.getFloat("gprice"));
            cars.setGnum(resultSet.getInt("gnum"));
            cars.setUid(resultSet.getInt("uid"));
            //把每个商品对象存入集合
            list.add(cars);
        }

        System.out.println("执行数据库成功！");
        //6、关闭数据库资源
        DBConn.close(resultSet, preparedStatement, connection);
        return list;
    }
}
