package com.czz.tomcat.my_servlet;

import com.czz.tomcat.handler.MyRequest;
import com.czz.tomcat.handler.MyResponse;
import com.czz.tomcat.servlet.MyServlet;

import java.io.IOException;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:42
 */
public class FindGirlServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
