package com.example.cugbacmpractice.spider;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

@Component
public class test2 implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);
    @Override
    public void process(Page page) {
        //System.out.println(page.getHtml().$("#pageContent > div.datatable > div:nth-child(6) > table > tbody > tr:nth-child(2) > td.status-cell.status-small.status-verdict-cell.dark > span > span","text").toString());
        System.out.println(page.getHtml().xpath("//*[@id=\"pageContent\"]/div[4]/div[6]/table/tbody/tr/td[6]/span/span/text()").all().toString());
        ////*[@id="pageContent"]/div[4]/div[6]/table/tbody/tr[2]/td[6]/span/span
    }

    @Override
    public Site getSite() {
        return site;
    }
    //https://codeforces.com/submissions/tourist

}
