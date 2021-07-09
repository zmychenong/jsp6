package com.sc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @PackageName com.sc.dao
 * @Classname DBConn
 * @Description TODO
 * @Date 2021/6/10 19:30
 * @Created by ChenLong
 */
public class DBConn {

    public static Connection getConn() {
        Connection connection = null;
        try {
            //1、注册mysql数据库驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("注册驱动成功！");
            //2、定义数据库连接信息，通过驱动管理器连接数据库
            //http://www.baidu.com:80
            //主要协议:次要协议://主机名:端口号/数据库名
            String url = "jdbc:mysql://localhost:3306/db2101";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接数据库成功！");
        } catch (Exception e) {
            System.out.println("连接数据库失败！");
        }

        return connection;
    }

    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
            System.out.println("关闭数据库资源成功");
        } catch (Exception e) {
            System.out.println("关闭数据库资源失败");
        }
    }

}
