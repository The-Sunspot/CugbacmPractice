package com.example.cugbacmpractice.spider;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
public class test implements PageProcessor  {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(10000);
    @Override
    public void process(Page page) {
        page.putField("author", page.getUrl().regex("https://gitee\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("html/body/div[3]/div[1]/div[2]/div[2]/div/h2/span[1]/a[2]").toString());
        if (page.getResultItems().get("name") == null) {
            page.setSkip(true);
        }
        page.addTargetRequests(page.getHtml().links().regex("(https://gitee\\.com/[\\w\\-]+/[\\w\\-]+)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {

        Spider.create(new test())
                .addUrl("https://gitee.com/lowcode-china")
                .thread(5)
                .run();
    }
}
