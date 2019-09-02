package com.czz.tomcat.handler;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-02 9:22
 */
@Data
public class MyRequest {
    private String url;
    private String method;

    public MyRequest(InputStream inputStream) throws IOException {
        String httpRequset = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes))>0) {
            httpRequset = new String(httpRequestBytes,0,length);
        }

        String httpHead = httpRequset.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }


}
