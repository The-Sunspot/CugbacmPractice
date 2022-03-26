package com.example.cugbacmpractice.spider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import us.codecraft.webmagic.Spider;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class test2Test {
    @Autowired
    test2 t2;
    //@Test
    public void wuu(){
        Spider.create(t2).addUrl("https://codeforces.com/submissions/tourist")
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}