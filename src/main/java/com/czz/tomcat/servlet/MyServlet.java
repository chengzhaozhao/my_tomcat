package com.czz.tomcat.servlet;

import com.czz.tomcat.handler.MyRequest;
import com.czz.tomcat.handler.MyResponse;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:33
 */
public abstract class MyServlet {
    public abstract void  doGet(MyRequest myRequest, MyResponse myResponse);

    public abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    public void service(MyRequest myRequest, MyResponse myResponse){
        if (myRequest.getMethod().equalsIgnoreCase("post")) {
            doPost(myRequest,myResponse);
        }else if(myRequest.getMethod().equalsIgnoreCase("get")){
            doGet(myRequest,myResponse);
        }
    }

}
