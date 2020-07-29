package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *  文档
 *  https://www.open-open.com/jsoup/selector-syntax.htm
 *
 *  utf8mb4不生效的问题 https://blog.csdn.net/wjf8882300/article/details/93711434
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupCountry {

    public static int i;

    @Autowired
    private LinkService linkService;

    @Test
    public void testGitHub() throws IOException {
        Document doc = Jsoup.connect("http://www.loglogo.com/front/countryCode/")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();
        Elements elements = doc.select("#resultDiv");
        Element first = elements.first();
        Elements aList = first.select("table");
        aList.forEach(e -> {
            e.select("tr").forEach(element -> {
                Element code = element.select("td").first();
                Element name = element.select("td").last();
                if(name !=null && code !=null){
                    System.out.println(code.text() +" "+name.text());
                }
            });
        });
    }
    public static void main(String[] args) throws IOException {




        System.out.println("仓库数量："+i);
    }

    public  void getDoc(String url) throws IOException {

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();

        Elements elements = document.select("#user-repositories-list");
        Element element = elements.first();

        Elements aList = element.select("li");
        List<Link> linkList = Lists.newArrayList();
        aList.forEach(e->{

            String href = e.select("h3>a").attr("abs:href");
            String title = e.select("h3").text();
            String desc = e.select("p").text();
            Link link = new Link();

            link.setTitle(title);
            link.setSummary(desc);
            link.setSource("gitHub");
            link.setCreateTime(new Date());
            link.setUpdateTime(new Date());
            link.setLink(href);
            //System.out.println(EmojiUtil.toAlias(desc));
            linkList.add(link);
            i++;
        });
        linkService.saveBatch(linkList);
        Elements select = element.select(".paginate-container a");
        List<Element> next = select.stream().filter(e -> e.text().equals("Next")).collect(Collectors.toList());
        if(!CollectionUtils.isEmpty(next)){
            getDoc(next.get(0).attr("href").toString());
        }
    }
}
