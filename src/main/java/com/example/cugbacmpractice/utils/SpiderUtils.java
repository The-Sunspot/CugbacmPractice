package com.example.cugbacmpractice.utils;

import com.example.cugbacmpractice.bean.CfData;
import com.example.cugbacmpractice.bean.VjData;
import com.example.cugbacmpractice.spider.DoSpider;
import com.example.cugbacmpractice.spider.test;
import org.springframework.stereotype.Component;
import org.w3c.dom.CDATASection;
import us.codecraft.webmagic.Spider;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class SpiderUtils {
    public VjData getVjData(String name){
        DoSpider spider = new DoSpider();
        List<String> xpaths=new ArrayList<>();
        xpaths.add("/html/body/div[1]/div[2]/div[3]/table/tbody/tr/td/a/text()");
        spider.setXpaths(xpaths);
        System.out.println("https://vjudge.net/user/"+name);
        Spider.create(spider).addUrl("https://vjudge.net/user/"+name).thread(10).run();
        List<String> results = spider.getResults();
        if(results==null||results.size()==0){
            System.out.println("null");
            return null;
        }
        VjData vjData = new VjData();
        vjData.setDaySolved(Integer.parseInt(results.get(0)));
        vjData.setWeekSolved(Integer.parseInt(results.get(1)));
        vjData.setMonthSolved(Integer.parseInt(results.get(2)));
        vjData.setAllSolved(Integer.parseInt(results.get(3)));
        vjData.setRecordDate(new Timestamp(new Date().getTime()));
        vjData.setProfileName(name);
        return vjData;
    }
    public CfData getCfData(String name){
        DoSpider spider = new DoSpider();
        List<String> xpaths=new ArrayList<>();
        xpaths.add("//*[@id=\"pageContent\"]/div[2]/div[5]/div[2]/ul/li[1]/span[1]/text()");
        xpaths.add("//*[@id=\"pageContent\"]/div[4]/div/div[7]/div[1]/div/div[1]/text()");
        spider.setXpaths(xpaths);
        Spider.create(spider).addUrl("https://codeforces.com/profile/"+name).thread(5).run();
        List<String> results = spider.getResults();
        if(results==null){
            System.out.println("null");
            return null;
        }
        CfData cfData = new CfData();
        String[] s = results.get(2).split(" ");
        cfData.setMonthSolved(Integer.parseInt(s[0]));
        s = results.get(1).split(" ");
        cfData.setAllSolved(Integer.parseInt(s[0]));
        s = results.get(0).split(" ");
        cfData.setRank(Integer.parseInt(s[0]));
        cfData.setProfileName(name);
        cfData.setRecordDate(new Timestamp(new Date().getTime()));

        return cfData;
    }
}
