package com.czz.tomcat.tomcat;

import com.czz.tomcat.config.ServletConfig;
import com.czz.tomcat.handler.MyRequest;
import com.czz.tomcat.handler.MyResponse;
import com.czz.tomcat.my_servlet.ServletMapping;
import com.czz.tomcat.servlet.MyServlet;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:49
 */
@Data
public class MyTomcat {
    private int port = 8080;

    private Map<String,String> urlServletMap = new HashMap<>();

    public MyTomcat(int port) {
        this.port = port;
    }


    public void start(){
        initServletMapping();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("mytomcat is stat()");

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                dispatch(myRequest,myResponse);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest,myResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void initServletMapping() {
        for (ServletMapping servletMapping : ServletConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }
}
