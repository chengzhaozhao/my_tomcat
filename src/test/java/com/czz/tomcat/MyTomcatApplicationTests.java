package com.czz.tomcat;

import com.czz.tomcat.tomcat.MyTomcat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTomcatApplicationTests {

    @Test
    public void contextLoads() {
        new MyTomcat(8080).start();
    }

}
