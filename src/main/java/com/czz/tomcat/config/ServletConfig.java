package com.czz.tomcat.config;

import com.czz.tomcat.my_servlet.ServletMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:46
 */
public class ServletConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();

    static {
        servletMappingList.add(new ServletMapping("findGirl","/girl","com.czz.tomcat.my_servlet.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWord","/word","com.czz.tomcat.my_servlet.HelloWordServlet"));
    }
}
