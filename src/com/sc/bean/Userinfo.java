package com.sc.bean;

/**
 * @PackageName com.sc.bean
 * @Classname Userinfo
 * @Description TODO
 * @Date 2021/6/8 19:46
 * @Created by ChenLong
 */
public class Userinfo {

    private int id;
    private String name;
    private String pass;
    private String sex;

    public Userinfo() {
    }

    public Userinfo(int id, String name, String pass, String sex) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
