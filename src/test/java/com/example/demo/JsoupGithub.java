package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 *  文档
 *  https://www.open-open.com/jsoup/selector-syntax.htm
 */
public class JsoupGithub {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://github.com/lyc88?tab=repositories")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                .get();

       // System.out.println(doc.html());
        Elements elements = doc.select("#user-repositories-list");
        Element first = elements.first();

        Elements aList = first.select("li");
        aList.forEach(e->{
            System.out.println(e.select("h3").text());
            System.out.println(e.select("p").text());

            System.out.println("============================");
        });


    }
}
