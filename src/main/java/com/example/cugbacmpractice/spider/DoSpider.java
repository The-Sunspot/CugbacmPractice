package com.example.cugbacmpractice.spider;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
@Component
public class DoSpider implements PageProcessor {


    private List<String> xpaths;
    private List<String> results;

    private Site site = Site.me().setRetryTimes(10).setSleepTime(20000).setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.74 Safari/537.36 Edg/99.0.1150.52");
    @Override
    public void process(Page page) {
        results=new ArrayList<>();
        for(String xpath : xpaths){
            results.addAll(page.getHtml().xpath(xpath).all());
        }
        for (String result : results) {
            System.out.println(result);
        }
    }
    @Override
    public Site getSite() {
        return site;
    }


    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
    public List<String> getXpaths() {
        return xpaths;
    }

    public void setXpaths(List<String> xpaths) {
        this.xpaths = xpaths;
    }
}
