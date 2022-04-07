/*
package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import com.google.common.collect.Lists;
import com.mzlion.easyokhttp.HttpClient;
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
import java.util.stream.Collectors;
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupGitee {
    public static void main(String[] args) throws IOException {
       Document doc = Jsoup.connect("https://gitee.com/www.lyc.com/projects")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();

        String totalPage = doc.select("#git-discover-page>a[class=item]").last().html();
        //page(Integer.parseInt(totalPage)+1);
    }
    @Autowired
    private LinkService linkService;

    @Test
    public void testGitee() throws IOException {
        Document doc = Jsoup.connect("https://gitee.com/www.lyc.com/projects")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();

        String totalPage = doc.select("#git-discover-page>a[class=item]").last().html();
        linkService.remove(new QueryWrapper<Link>().eq("source","gitee"));
        page(Integer.parseInt(totalPage)+1);
    }
    public  void page(int totalPage) throws IOException {
        for (int i = 1; i <= totalPage; i++) {
            System.out.println("page==============================:"+i);
            Document doc = Jsoup.connect("https://gitee.com/www.lyc.com/projects?page="+i)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                    .get();
            Element select = doc.select("#search-projects-ulist").first();
            List<Link> linkList = Lists.newArrayList();
            if(select != null)
            select.select("div[class=project list-warpper]").stream().forEach(e->{
                Elements a = e.select("span[class=project-title] a ");
                String title = a.text();
                String href = a.attr("abs:href");
                String desc = e.select("p").text();
                Link link = new Link();
                //System.out.println(EmojiUtil.toAlias(desc));
                link.setTitle(title);
                link.setSummary(desc);
                link.setSource("gitee");
                link.setCreateTime(new Date());
                link.setUpdateTime(new Date());
                link.setLink(href);

                linkList.add(link);
            });
            linkService.saveBatch(linkList);
        }

    }
}
*/
