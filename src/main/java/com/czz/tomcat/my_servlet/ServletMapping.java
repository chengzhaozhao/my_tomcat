package com.czz.tomcat.my_servlet;

import lombok.Data;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:45
 */
@Data
public class ServletMapping {
    private String servletName;
    private String url;
    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

}
