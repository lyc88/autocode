/*
package com.example.demo;

import cn.hutool.json.JSONUtil;
import com.example.demo.test.entity.Link;
import com.example.demo.test.service.LinkService;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
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

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

*/
/**
 *  文档
 *  https://www.open-open.com/jsoup/selector-syntax.htm
 *
 *  utf8mb4不生效的问题 https://blog.csdn.net/wjf8882300/article/details/93711434
 *//*


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


    @Test
    public  void getCountry() throws IOException {
        List<String> readLines = FileUtils.readLines(new File("d:\\国家地区区号.txt"));
        List<String> list = readLines.stream()
                .map((e -> e.replace(",", "").replace("\"","").trim())).collect(Collectors.toList());

        list.forEach(e-> {
                    String[] split = e.split("-");
                    String s = split[0];
                    String s1 = split[1];
                    String s2 = split[2];
                    char c = s.charAt(0);
                });

        List<String> ar = Lists.newArrayList();
        Document doc = Jsoup.connect("https://www.iamwawa.cn/shicha.html")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();
        Elements elements = doc.select(".content-body");
        Element first = elements.first();
        Elements aList = first.select("table");
        AtomicInteger i= new AtomicInteger(1);
        aList.forEach(e -> {

            Elements thElements = e.select("th");
            thElements.forEach(td->{
                System.out.print(td.text()+" ");
            });

            e.select("tr").forEach(element -> {
                Elements tdElements = element.select("td");
                Iterator<Element> iterator = tdElements.iterator();
                String str = "";
                while (iterator.hasNext()){
                    Element next = iterator.next();
                    str += next.text()+"-" ;
                }
                ar.add(str);
                i.getAndIncrement();
            });
            System.out.println(i);
        });
        HashMap<String,String> map = new HashMap<>();
        List<String> sList = Lists.newArrayList();
        ar.forEach(e-> {
            if(StringUtils.isNotBlank(e)){
                String[] split = e.split("-");
                String s = split[0];
                String s1 = split[1];
                String s2 = split[2];
                String s3 = split[3];
                char c = s.charAt(0);
                String str = s + "-"+s1+"-" + s3;
                sList.add(str);
                map.put(str,s2);
            }
        });

        sList.forEach(str->{
            if(!list.contains(str)){
                list.add(str);
            }else {
                System.out.println(str);
            }
        });

        FileUtils.write(new File("d:\\完整的世界各国中英文名字及区号.txt"), JSONUtil.toJsonPrettyStr(list),"utf-8");
        System.out.println("完成");
    }
}
*/
