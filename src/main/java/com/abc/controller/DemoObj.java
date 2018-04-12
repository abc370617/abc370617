package com.abc.controller;
        /*
         *  author  :  ajing
         *  date    :  2018/4/12 16:42
         * */

public class DemoObj {
    private int id;
    private String name;

    public DemoObj() {

    }
    public DemoObj(int id, String name) {
        this.id = id;
        this.name = name;
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
}
